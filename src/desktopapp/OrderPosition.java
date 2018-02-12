package desktopapp;

public class OrderPosition {

    private long id;
    private long orderId;
    private long productId;
    private float price;
    private long itemCount;

    public OrderPosition() {
    }

    
    public OrderPosition(long id, long orderId, long productId, float price, long itemCount){
        this.id=id;
        this.productId=productId;
        this.price=price;
        this.orderId=orderId;
        this.itemCount=itemCount;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getItemCount() {
        return itemCount;
    }

    public void setItemCount(long itemCount) {
        this.itemCount = itemCount;
    }
    
}
