package signup;
public class UserService {


    void join(User user) {
        user.validateId();
        user.validatePassword();
        user.validateName();
        System.out.println("회원가입 가능한 정보입니다");
    }
}
