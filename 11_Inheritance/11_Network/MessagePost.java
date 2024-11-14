public class MessagePost extends Post {
    private String message;

    public MessagePost(String username, String message) {
        super(username);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Message: " + message);
    }
}
