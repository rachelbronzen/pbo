public class LoginHandler {
    //data
    private String validUsername = "user";
    private String validPassword = "root";

    //periksa autentikasi
    public boolean authenticate(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
