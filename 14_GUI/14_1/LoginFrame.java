import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public LoginFrame() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLayout(new BorderLayout());

        //form login panel
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        formPanel.add(new JLabel("Username: "));
        usernameField = new JTextField();
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Password: "));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        loginButton = new JButton("Login");
        formPanel.add(new JLabel());
        formPanel.add(loginButton);

        //form panel pada frame
        add(formPanel, BorderLayout.CENTER);

        //status label di bawah form
        statusLabel = new JLabel(" ", SwingConstants.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        //tombol login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                LoginHandler handler = new LoginHandler();
                if (handler.authenticate(username, password)) {
                    statusLabel.setText("Login successful!");
                } else {
                    statusLabel.setText("Invalid username or password.");
                }
            }
        });

        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
