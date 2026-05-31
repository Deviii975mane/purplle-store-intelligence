package com.purplle.storeintelligence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "store_sales")
public class StoreSalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id") private String orderId;
    @Column(name = "coupon_code") private String couponCode;
    @Column(name = "offer_name") private String offerName;
    @Column(name = "discount_code") private String discountCode;
    @Column(name = "invoice_number") private String invoiceNumber;
    @Column(name = "invoice_type") private String invoiceType;
    @Column(name = "order_date") private String orderDate;
    @Column(name = "order_time") private String orderTime;
    @Column(name = "return_id") private String returnId;
    @Column(name = "store_id") private String storeId;
    @Column(name = "store_name") private String storeName;
    @Column(name = "city") private String city;
    @Column(name = "customer_name") private String customerName;
    @Column(name = "customer_number") private String customerNumber;
    @Column(name = "sku") private String sku;
    @Column(name = "product_id") private String productId;
    @Column(name = "ean") private String ean;
    @Column(name = "product_name") private String productName;
    @Column(name = "brand_name") private String brandName;
    @Column(name = "dep_name") private String depName;
    @Column(name = "sub_category") private String subCategory;
    @Column(name = "brand_type") private String brandType;
    @Column(name = "tax") private BigDecimal tax;
    @Column(name = "hsn_code") private String hsnCode;
    @Column(name = "salesperson_id") private String salespersonId;
    @Column(name = "employee_code") private String employeeCode;
    @Column(name = "salesperson_name") private String salespersonName;
    @Column(name = "qty") private Integer qty;
    @Column(name = "gmv") private BigDecimal gmv;
    @Column(name = "nmv") private BigDecimal nmv;
    @Column(name = "coupon_amount") private BigDecimal couponAmount;
    @Column(name = "item_promotion") private BigDecimal itemPromotion;
    @Column(name = "amt_without_gwp") private BigDecimal amtWithoutGwp;
    @Column(name = "total_amount") private BigDecimal totalAmount;
    @Column(name = "pb_eb_sale") private String pbEbSale;
    @Column(name = "week_assigned") private String weekAssigned;
    @Column(name = "tax_m") private BigDecimal taxM;
    @Column(name = "taxable_amt") private BigDecimal taxableAmt;
    @Column(name = "tax_amt") private BigDecimal taxAmt;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getCouponCode() { return couponCode; }
    public void setCouponCode(String couponCode) { this.couponCode = couponCode; }
    public String getOfferName() { return offerName; }
    public void setOfferName(String offerName) { this.offerName = offerName; }
    public String getDiscountCode() { return discountCode; }
    public void setDiscountCode(String discountCode) { this.discountCode = discountCode; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public String getInvoiceType() { return invoiceType; }
    public void setInvoiceType(String invoiceType) { this.invoiceType = invoiceType; }
    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public String getOrderTime() { return orderTime; }
    public void setOrderTime(String orderTime) { this.orderTime = orderTime; }
    public String getReturnId() { return returnId; }
    public void setReturnId(String returnId) { this.returnId = returnId; }
    public String getStoreId() { return storeId; }
    public void setStoreId(String storeId) { this.storeId = storeId; }
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerNumber() { return customerNumber; }
    public void setCustomerNumber(String customerNumber) { this.customerNumber = customerNumber; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getEan() { return ean; }
    public void setEan(String ean) { this.ean = ean; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getBrandName() { return brandName; }
    public void setBrandName(String brandName) { this.brandName = brandName; }
    public String getDepName() { return depName; }
    public void setDepName(String depName) { this.depName = depName; }
    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }
    public String getBrandType() { return brandType; }
    public void setBrandType(String brandType) { this.brandType = brandType; }
    public BigDecimal getTax() { return tax; }
    public void setTax(BigDecimal tax) { this.tax = tax; }
    public String getHsnCode() { return hsnCode; }
    public void setHsnCode(String hsnCode) { this.hsnCode = hsnCode; }
    public String getSalespersonId() { return salespersonId; }
    public void setSalespersonId(String salespersonId) { this.salespersonId = salespersonId; }
    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }
    public String getSalespersonName() { return salespersonName; }
    public void setSalespersonName(String salespersonName) { this.salespersonName = salespersonName; }
    public Integer getQty() { return qty; }
    public void setQty(Integer qty) { this.qty = qty; }
    public BigDecimal getGmv() { return gmv; }
    public void setGmv(BigDecimal gmv) { this.gmv = gmv; }
    public BigDecimal getNmv() { return nmv; }
    public void setNmv(BigDecimal nmv) { this.nmv = nmv; }
    public BigDecimal getCouponAmount() { return couponAmount; }
    public void setCouponAmount(BigDecimal couponAmount) { this.couponAmount = couponAmount; }
    public BigDecimal getItemPromotion() { return itemPromotion; }
    public void setItemPromotion(BigDecimal itemPromotion) { this.itemPromotion = itemPromotion; }
    public BigDecimal getAmtWithoutGwp() { return amtWithoutGwp; }
    public void setAmtWithoutGwp(BigDecimal amtWithoutGwp) { this.amtWithoutGwp = amtWithoutGwp; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public String getPbEbSale() { return pbEbSale; }
    public void setPbEbSale(String pbEbSale) { this.pbEbSale = pbEbSale; }
    public String getWeekAssigned() { return weekAssigned; }
    public void setWeekAssigned(String weekAssigned) { this.weekAssigned = weekAssigned; }
    public BigDecimal getTaxM() { return taxM; }
    public void setTaxM(BigDecimal taxM) { this.taxM = taxM; }
    public BigDecimal getTaxableAmt() { return taxableAmt; }
    public void setTaxableAmt(BigDecimal taxableAmt) { this.taxableAmt = taxableAmt; }
    public BigDecimal getTaxAmt() { return taxAmt; }
    public void setTaxAmt(BigDecimal taxAmt) { this.taxAmt = taxAmt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
