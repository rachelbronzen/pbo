public class BusinessTicket extends Ticket {
    private static final double PRICE_PER_TICKET = 150.0;

    public BusinessTicket(int quantity) {
        super(quantity);
    }

    @Override
    public String getFacilities() {
        return "Spacious seat, meal service, personal entertainment, priority boarding.";
    }

    @Override
    public String getLevel() {
        return "Business";
    }

    @Override
    public double getPrice() {
        return PRICE_PER_TICKET * getQuantity();
    }
}
