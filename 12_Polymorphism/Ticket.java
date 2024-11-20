public abstract class Ticket {
    private int quantity;

    public Ticket(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getFacilities();

    public abstract String getLevel();

    public abstract double getPrice();
}
