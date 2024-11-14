import java.util.ArrayList;

public class NewsFeed {
    private ArrayList<MessagePost> messagePosts;
    private ArrayList<PhotoPost> photoPosts;

    public NewsFeed() {
        messagePosts = new ArrayList<>();
        photoPosts = new ArrayList<>();
    }

    public void addMessagePost(MessagePost post) {
        messagePosts.add(post);
    }

    public void addPhotoPost(PhotoPost post) {
        photoPosts.add(post);
    }

    public void displayAllPosts() {
        System.out.println("Displaying all message posts:");
        for (MessagePost post : messagePosts) {
            post.display();
            System.out.println("-------------------");
        }
        System.out.println("Displaying all photo posts:");
        for (PhotoPost post : photoPosts) {
            post.display();
            System.out.println("-------------------");
        }
    }

    public void displayPostsByUser(String username) {
        System.out.println("Displaying posts by user: " + username);
        for (MessagePost post : messagePosts) {
            if (post.getUsername().equals(username)) {
                post.display();
                System.out.println("-------------------");
            }
        }
        for (PhotoPost post : photoPosts) {
            if (post.getUsername().equals(username)) {
                post.display();
                System.out.println("-------------------");
            }
        }
    }
}
