import java.awt.image.BufferedImage;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    private BufferedImage currentImage;

    public void loadImage(File file) {
        try {
            currentImage = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public void rotateImage() {
        if (currentImage != null) {
            int width = currentImage.getWidth();
            int height = currentImage.getHeight();
            BufferedImage rotatedImage = new BufferedImage(height, width, currentImage.getType());

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotatedImage.setRGB(y, width - 1 - x, currentImage.getRGB(x, y));
                }
            }
            currentImage = rotatedImage;
        }
    }
}
