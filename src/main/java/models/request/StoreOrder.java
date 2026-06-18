package models.request;

public class StoreOrder {
    private int id;
    private int petId;
    private int quantity;
    private String status;
    private boolean complete;

    public StoreOrder() {}

    public StoreOrder(int id, int petId, int quantity, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.status = status;
        this.complete = complete;
    }

    public int getId() { return id; }
    public int getPetId() { return petId; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
    public boolean isComplete() { return complete; }

    public void setId(int id) { this.id = id; }
    public void setPetId(int petId) { this.petId = petId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setStatus(String status) { this.status = status; }
    public void setComplete(boolean complete) { this.complete = complete; }
}
