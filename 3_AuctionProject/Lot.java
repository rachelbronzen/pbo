public class Lot {
    private int lotNumber; 
    private String description;
    private Bid currentBid; 

    public Lot(int lotNumber, String description) {
        this.lotNumber = lotNumber;
        this.description = description;
        this.currentBid = null;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setCurrentBid(Bid bid) {
        this.currentBid = bid;
    }

    public Bid getCurrentBid() {
        return currentBid;
    }
    @Override
    public String toString() {
        return "Lot " + lotNumber + ": " + description + 
               (currentBid != null ? " | Current bid: " + currentBid : " | No bids yet");
    }
}

