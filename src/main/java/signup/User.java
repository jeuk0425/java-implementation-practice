package signup;

public class User {
    private String id;
    private String password;
    private String name;

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }


    void validateId() {
        if (id.length() < 5 || id.length() > 12) {
            throw new IllegalArgumentException("아이디는 5자이상 12자 이하여야합니다.");
        }
        for (int i = 0; i<id.length(); i++) {
            char c = id.charAt(i);
            if (!(c >= 'a' && c <= 'z' || Character.isDigit(c))) {
                throw new IllegalArgumentException("아이디는 영문 소문자와 숫자만 사용 할 수 있습니다");
            }
        }
        if (id.contains(" ")) {
            throw new IllegalArgumentException("아이디는 공백을 포함할 수 없습니다");
            //이미 소문자,숫자검사에서 걸리긴함 그래도 연습겸 사용
        }
    }

    void validatePassword() {
        if (password.length() < 8 || password.length() > 20) {
            throw new IllegalArgumentException("비밀번호는 8자 이상 20자 이하여야 입니다.");
        }
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ((c>='a'&& c<='z' || c>='A' && c<='Z')){
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        if (!hasLetter) {
            throw new IllegalArgumentException("비밀번호에는 영문자가 최소 1개 포함되어야 합니다");
        }

        if (!hasDigit) {
            throw new IllegalArgumentException("비밀번호에는 숫자가 최소 1개 포함되어야 합니다.");
        }/*
        반복문 전에 hasLetter = false, hasDigit = false
        반복하면서 찾으면 true로 바꿈
        반복 다 끝난 뒤 아직 false면 → 하나도 못 찾은 것
        */
        if (password.contains(" ")) {
            throw new IllegalArgumentException("비밀번호는 공백을 포함할 수 없습니다.");
        }

    }

    void validateName() {
        if (name.length() < 2 || name.length() > 10) {
            throw new IllegalArgumentException("이름은 2자이상 10자 이하합니다");
        }
        /*공백만 입력된값은 항상 허용하지않아야함
        사고과정 : 공백을없앤다->결과가 빈 문자열인지 확인한다->비어있으면 공백만 입력된 값
        */
        if (name.trim().isEmpty()) {
          throw new IllegalArgumentException("공백만 입력된값은 허용하지않습니다");
        }


    }


}

