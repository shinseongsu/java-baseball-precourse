package baseball.model;

import baseball.uitl.RandomUtil;

public class Computer {

    private String number;

    public Computer() {
        this.number = RandomUtil.create();
    }

    public String getNumber() {
        return number;
    }

}
