public class EconomyTicket extends Ticket {
    private static final double PRICE_PER_TICKET = 50.0;

    public EconomyTicket(int quantity) {
        super(quantity);
    }

    @Override
    public String getFacilities() {
        return "Basic seat, complimentary drink, shared entertainment.";
    }

    @Override
    public String getLevel() {
        return "Economy";
    }

    @Override
    public double getPrice() {
        return PRICE_PER_TICKET * getQuantity();
    }
}
