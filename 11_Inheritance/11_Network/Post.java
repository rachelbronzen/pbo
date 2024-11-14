import java.util.ArrayList;
import java.util.Date;

public class Post {
    private String username;
    private Date timestamp;
    private int likes;
    private ArrayList<String> comments;

    public Post(String username) {
        this.username = username;
        this.timestamp = new Date();
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public void like() {
        likes++;
    }

    public void unlike() {
        if (likes > 0) {
            likes--;
        }
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public String getUsername() {
        return username;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void display() {
        System.out.println("Username: " + username);
        System.out.println("Likes: " + likes);
        System.out.println("Comment: " + comments);
        System.out.println("Posted: " + timestamp);
    }
}
