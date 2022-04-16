package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;

public class BaseballController {

    public void start() {
        boolean exit = true;
        do {
            Computer computer = new Computer();
            play(computer);
        } while(exit);
    }

    public void play(Computer computer) {
        // 실행
        User user = new User(InputView.inputofNumber());
    }

}
