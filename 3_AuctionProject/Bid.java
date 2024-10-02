public class Bid {
    private Person person;
    private double amount; 

    public Bid(Person person, double amount) {
        this.person = person;
        this.amount = amount;
    }

    public Person getPerson() {
        return person;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bid by " + person.getName() + " of $" + amount;
    }
}
