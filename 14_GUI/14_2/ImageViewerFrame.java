import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewerFrame extends JFrame {
    private JLabel imageLabel; //menampilkan gambar
    private ImageHandler imageHandler; //pengelola gambar

    public ImageViewerFrame() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        imageHandler = new ImageHandler();

        //menampilkan gambar
        imageLabel = new JLabel("", SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton openButton = new JButton("Open Image");
        JButton rotateButton = new JButton("Rotate Image");

        buttonPanel.add(openButton);
        buttonPanel.add(rotateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        //tombol Open
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = openImageDialog();
                if (file != null) {
                    imageHandler.loadImage(file);
                    imageLabel.setIcon(new ImageIcon(imageHandler.getCurrentImage()));
                }
            }
        });

        //tombol Rotate
        rotateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (imageHandler.getCurrentImage() != null) {
                    imageHandler.rotateImage();
                    imageLabel.setIcon(new ImageIcon(imageHandler.getCurrentImage()));
                } else {
                    JOptionPane.showMessageDialog(null, "No image loaded to rotate!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    //memilih file gambar
    private File openImageDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
}
