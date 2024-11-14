public class PhotoPost extends Post {
    private String filename;
    private String caption;

    public PhotoPost(String username, String filename, String caption) {
        super(username);
        this.filename = filename;
        this.caption = caption;
    }

    public String getFilename() {
        return filename;
    }

    public String getCaption() {
        return caption;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("File: " + filename);
        System.out.println("Caption: " + caption);
    }
}
