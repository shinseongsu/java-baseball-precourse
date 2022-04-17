package baseball.validate;

public class Validator {

    public void validate(String number) {
        nullOrEmptyCheck(number);
        fourLength(number);
        numberCheck(number);
        overlapCheck(number);
    }

    public void nullOrEmptyCheck(String number) {
        if(number == null || "".equals(number)) {
            throw new IllegalArgumentException("빈 값을 입력하였습니다.");
        }
    }

    public void fourLength(String number) {
        if(number.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력이 가능합니다.");
        }
    }

    public void numberCheck(String number) {
        if(!number.matches("^[1-9]*$")) {
            throw new IllegalArgumentException("1~9가 아닌값이 들어왔습니다.");
        }
    }

    public void overlapCheck(String number) {
        for(int i = 0 ; i < number.length() ; i++) {
            isOverlap(number, number.charAt(i));
        }
    }

    public void isOverlap(String number, char searchNumber) {
        if(number.indexOf(searchNumber) != number.lastIndexOf(searchNumber)) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
    }

    public void isOneOrTwo(String answer) {
        if(answer.matches("^[^1|2]*$"))  {
            throw new IllegalArgumentException("1과 2 이외에 다른 값이 들어왔습니다.");
        }
    }

}
