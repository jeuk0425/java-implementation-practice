package signup;

public class SignUpMain {
    public static void main(String[] args) {

        User user = new User("a4dfdd", "aaaaaaaaa", "jeuk");

        UserService userService = new UserService();

        try {
            userService.join(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
