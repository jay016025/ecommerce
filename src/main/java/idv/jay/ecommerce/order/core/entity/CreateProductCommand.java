package idv.jay.ecommerce.order.core.entity;

public interface CreateProductCommand {
    String getProductName();

    String getDesc();

    java.math.BigDecimal getPrice();

    String getUnit();

    void setProductName(String productName);

    void setDesc(String desc);

    void setPrice(java.math.BigDecimal price);

    void setUnit(String unit);
}
