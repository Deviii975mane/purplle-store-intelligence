import { useState, useEffect } from 'react';
import axios from 'axios';

export default function App() {
  const [alerts, setAlerts] = useState([]);
  const [isLive, setIsLive] = useState(true);

  // Fetch data from the Java API
  const fetchAlerts = async () => {
    try {
      const response = await axios.get('/api/v1/metrics/alerts');
      // Sort so the newest alerts are at the top
      const sortedData = response.data.sort((a, b) => b.id - a.id);
      setAlerts(sortedData);
    } catch (err) {
      console.error("Error fetching data:", err);
    }
  };

  // Auto-refresh the dashboard every 3 seconds
  useEffect(() => {
    fetchAlerts();
    let interval;
    if (isLive) {
      interval = setInterval(fetchAlerts, 3000);
    }
    return () => clearInterval(interval);
  }, [isLive]);

  return (
    <div className="min-h-screen bg-gray-950 text-gray-100 p-8 font-sans">

      {/* Header Section */}
      <div className="max-w-7xl mx-auto flex justify-between items-center mb-8">
        <div>
          <h1 className="text-3xl font-bold tracking-tight text-white">Purplle Security Command Center</h1>
          <p className="text-gray-400 mt-1">Live AI Threat Detection Architecture</p>
        </div>
        <button
          onClick={() => setIsLive(!isLive)}
          className={`px-4 py-2 rounded font-semibold transition-colors ${isLive ? 'bg-red-500/20 text-red-400 border border-red-500/50 hover:bg-red-500/30' : 'bg-gray-800 text-gray-400 border border-gray-700 hover:bg-gray-700'}`}
        >
          {isLive ? '🔴 LIVE STREAM ACTIVE' : '⏸ PAUSED'}
        </button>
      </div>

      {/* Metrics Cards */}
      <div className="max-w-7xl mx-auto grid grid-cols-1 md:grid-cols-3 gap-6 mb-8">
        <div className="bg-gray-900 border border-gray-800 p-6 rounded-lg shadow-lg">
          <h3 className="text-gray-400 text-sm font-medium">Total Anomalies Detected</h3>
          <p className="text-4xl font-bold text-white mt-2">{alerts.length}</p>
        </div>
        <div className="bg-gray-900 border border-gray-800 p-6 rounded-lg shadow-lg">
          <h3 className="text-gray-400 text-sm font-medium">Critical Threats</h3>
          <p className="text-4xl font-bold text-red-500 mt-2">
            {/* Updated to camelCase */}
            {alerts.filter(a => a.riskLevel === 'CRITICAL').length}
          </p>
        </div>
        <div className="bg-gray-900 border border-gray-800 p-6 rounded-lg shadow-lg">
          <h3 className="text-gray-400 text-sm font-medium">Active Cameras</h3>
          <p className="text-4xl font-bold text-purple-500 mt-2">
            {/* Updated to camelCase */}
            {new Set(alerts.map(a => a.currentZone)).size}
          </p>
        </div>
      </div>

      {/* Data Table */}
      <div className="max-w-7xl mx-auto bg-gray-900 border border-gray-800 rounded-lg shadow-lg overflow-hidden">
        <table className="w-full text-left border-collapse">
          <thead>
            <tr className="bg-gray-950 border-b border-gray-800 text-gray-400 text-sm uppercase tracking-wider">
              <th className="p-4 font-medium">Time</th>
              <th className="p-4 font-medium">Location</th>
              <th className="p-4 font-medium">Entity ID</th>
              <th className="p-4 font-medium">Suspicion %</th>
              <th className="p-4 font-medium">Status</th>
              <th className="p-4 font-medium">Risk Level</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-gray-800">
            {alerts.slice(0, 50).map((alert) => (
              <tr key={alert.id} className="hover:bg-gray-800/50 transition-colors">
                <td className="p-4 text-sm text-gray-300">
                  {new Date(alert.timestamp).toLocaleTimeString()}
                </td>
                <td className="p-4 text-sm font-mono text-purple-400">
                  {/* Updated to camelCase */}
                  {alert.currentZone}
                </td>
                <td className="p-4 text-sm text-gray-300">
                  {/* Updated to camelCase */}
                  {alert.entityId}
                </td>
                <td className="p-4 text-sm font-semibold">
                  {/* Updated to camelCase and fixed NaN math */}
                  {alert.suspicionConfidence ? (alert.suspicionConfidence * 100).toFixed(0) : 0}%
                </td>
                <td className="p-4 text-sm">
                  <span className="bg-gray-800 text-gray-300 px-2 py-1 rounded text-xs border border-gray-700">
                    {/* Updated to camelCase */}
                    {alert.productTrackingStatus}
                  </span>
                </td>
                <td className="p-4 text-sm">
                  <span className="bg-red-500/10 text-red-400 border border-red-500/20 px-2 py-1 rounded text-xs font-bold">
                    {/* Updated to camelCase */}
                    {alert.riskLevel}
                  </span>
                </td>
              </tr>
            ))}
            {alerts.length === 0 && (
              <tr>
                <td colSpan="6" className="p-8 text-center text-gray-500">
                  Awaiting incoming AI telemetry...
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}