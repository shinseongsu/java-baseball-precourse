package baseball.model;

import baseball.validate.Validator;

public class User {

    private String number;

    public User(String number) {
        Validator validator = new Validator();
        validator.validate(number);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

}
