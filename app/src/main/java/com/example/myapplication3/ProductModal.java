package com.example.myapplication3;
public class ProductModal {

    // variables for our coursename,
    // description, tracks and duration, id.
    private String ProductName;
    private String buyingPrice;
    private String sellingPrice;
    private String productCategory;
    private int id;

    // creating getter and setter methods
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(String buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String returnString() {
        StringBuilder newString = new StringBuilder();
        newString.append(String.format("ProductName = %s\n", this.ProductName))
                .append(String.format("BuyingPrice = %s\n", this.buyingPrice))
                .append("SellingPrice = " + sellingPrice + "\n")
                .append("ProductCategory = " + productCategory + "\n") ;
        return String.valueOf(newString);
    }

    // constructor
    public ProductModal(String courseName, String buyingPrice, String sellingPrice, String productCategory) {
        this.ProductName = courseName;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.productCategory = productCategory;
    }
}
