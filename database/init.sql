-- database/init.sql

CREATE TABLE IF NOT EXISTS store_sales (
    id SERIAL PRIMARY KEY,
    order_id VARCHAR(100),
    coupon_code VARCHAR(100),
    offer_name VARCHAR(255),
    discount_code VARCHAR(100),
    invoice_number VARCHAR(100),
    invoice_type VARCHAR(100),
    order_date VARCHAR(50),
    order_time VARCHAR(50),
    return_id VARCHAR(100),
    store_id VARCHAR(100),
    store_name VARCHAR(255),
    city VARCHAR(100),
    customer_name VARCHAR(255),
    customer_number VARCHAR(50),
    sku VARCHAR(100),
    product_id VARCHAR(100),
    ean VARCHAR(100),
    product_name VARCHAR(255),
    brand_name VARCHAR(255),
    dep_name VARCHAR(100),
    sub_category VARCHAR(100),
    brand_type VARCHAR(100),
    tax NUMERIC(10, 2),
    hsn_code VARCHAR(50),
    salesperson_id VARCHAR(100),
    employee_code VARCHAR(100),
    salesperson_name VARCHAR(255),
    qty INT,
    gmv NUMERIC(12, 2),
    nmv NUMERIC(12, 2),
    coupon_amount NUMERIC(12, 2),
    item_promotion NUMERIC(12, 2),
    amt_without_gwp NUMERIC(12, 2),
    total_amount NUMERIC(12, 2),
    pb_eb_sale VARCHAR(100),
    week_assigned VARCHAR(50),
    tax_m NUMERIC(10, 2),
    taxable_amt NUMERIC(12, 2),
    tax_amt NUMERIC(12, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- High-performance database indexes for retail analytical endpoints
CREATE INDEX IF NOT EXISTS idx_sales_store ON store_sales(store_id);
CREATE INDEX IF NOT EXISTS idx_sales_product ON store_sales(product_id);
CREATE INDEX IF NOT EXISTS idx_sales_date ON store_sales(order_date);

-- Template example for loading your 102 lines of data below:
-- INSERT INTO store_sales (order_id, coupon_code, offer_name, discount_code, invoice_number, invoice_type, order_date, order_time, return_id, store_id, store_name, city, customer_name, customer_number, sku, product_id, ean, product_name, brand_name, dep_name, sub_category, brand_type, tax, hsn_code, salesperson_id, employee_code, salesperson_name, qty, gmv, nmv, coupon_amount, item_promotion, amt_without_gwp, total_amount, pb_eb_sale, week_assigned, tax_m, taxable_amt, tax_amt) 
-- VALUES ('ORD1001', 'NONE', 'Regular', 'DSC0', 'INV-001', 'Tax Invoice', '2026-05-31', '14:30:00', 'NULL', 'STR_01', 'Purplle Mumbai', 'Mumbai', 'John Doe', '9999999999', 'SKU-88', 'P_88', 'EAN-88', 'Lipstick', 'Faces Canada', 'Cosmetics', 'Lips', 'Premium', 18.00, 'HSN123', 'SP_44', 'EMP_44', 'Alex S.', 1, 299.00, 299.00, 0.00, 0.00, 299.00, 299.00, 'Regular', 'Week 22', 18.00, 253.39, 45.61);