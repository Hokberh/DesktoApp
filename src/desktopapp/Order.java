package desktopapp;

public class Order {

    private long id;
    private String description;
    private String date;
    private float totalCost;

    public Order() {
    }
    
    public Order(long id, String description, String date, float totalCost){
        this.id=id;
        this.description=description;
        this.date=date;
        this.totalCost=totalCost;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
    
    
}
