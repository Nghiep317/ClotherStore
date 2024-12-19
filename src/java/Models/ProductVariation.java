/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author wvrtu
 */
public class ProductVariation {
    private int variationId;
    private Product product;
    private String color;
    private String size;
    private double price;
    private int quantity;
    private boolean isRemoved;

    public ProductVariation() {
    }

    public ProductVariation(int variationId, Product product, String color, String size, double price, int quantity, boolean isRemoved) {
        this.variationId = variationId;
        this.product = product;
        this.color = color;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.isRemoved = isRemoved;
    }
    
    public int getVariationId() {
        return variationId;
    }

    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
}