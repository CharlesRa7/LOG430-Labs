package ets.log430.lab.models.dto;

public class SaleProductDto {
    private String productName;
    private int quantity;
    private double subTotal;

    public SaleProductDto(String productName, int quantity, double subTotal) {
        this.productName = productName;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
