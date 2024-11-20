public class FirstClassTicket extends Ticket {
    private static final double PRICE_PER_TICKET = 300.0;

    public FirstClassTicket(int quantity) {
        super(quantity);
    }

    @Override
    public String getFacilities() {
        return "Luxury suite, gourmet meal, premium entertainment, private check-in.";
    }

    @Override
    public String getLevel() {
        return "First Class";
    }

    @Override
    public double getPrice() {
        return PRICE_PER_TICKET * getQuantity();
    }
}
