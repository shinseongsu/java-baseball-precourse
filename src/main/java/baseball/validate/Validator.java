package baseball.validate;

import baseball.constant.BaseballConstant;

public class Validator {

    public void validate(String number) {
        nullOrEmptyCheck(number);
        fourLength(number);
        numberCheck(number);
        overlapCheck(number);
    }

    public void nullOrEmptyCheck(String number) {
        if(number == null || "".equals(number)) {
            throw new IllegalArgumentException(BaseballConstant.NULL_MESSAGE);
        }
    }

    public void fourLength(String number) {
        if(number.length() != 3) {
            throw new IllegalArgumentException(BaseballConstant.LENGTH_MESSAGE);
        }
    }

    public void numberCheck(String number) {
        if(!number.matches("^[1-9]*$")) {
            throw new IllegalArgumentException(BaseballConstant.NUMBER_MESSAGE);
        }
    }

    public void overlapCheck(String number) {
        for(int i = 0 ; i < number.length() ; i++) {
            isOverlap(number, number.charAt(i));
        }
    }

    public void isOverlap(String number, char searchNumber) {
        if(number.indexOf(searchNumber) != number.lastIndexOf(searchNumber)) {
            throw new IllegalArgumentException(BaseballConstant.OVERLAP_MESSAGE);
        }
    }

    public void isOneOrTwo(String answer) {
        if(answer.matches("^[^1|2]*$"))  {
            throw new IllegalArgumentException(BaseballConstant.NOT_ONEANDTWO_MESSAGE);
        }
    }

}
