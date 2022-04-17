package baseball.controller;

import baseball.model.Computer;
import baseball.model.Count;
import baseball.model.User;
import baseball.validate.Validator;
import baseball.view.InputView;
import baseball.view.ResultView;


public class BaseballController {

    public void start() {
        boolean exit = true;
        do {
            Computer computer = new Computer();
            play(computer);
            exit = isRestart(InputView.inputOfRestart());
        } while(exit);
    }

    public void play(Computer computer) {
        boolean isAllStrike = true;
        while(isAllStrike) {
            isAllStrike = !isCorrect(InputView.inputofNumber(), computer);
        }
    }

    public boolean isRestart(String answer) {
        Validator validator = new Validator();
        validator.isOneOrTwo(answer);
        return "1".equals(answer) ? true : false;
    }

    public boolean isCorrect(String input, Computer computer) {
        User user = new User(input);
        Count count = new Count();
        String answer = count.strikeOrBallCheck(computer.getNumber(), user.getNumber());
        ResultView.answerResultAndEnter(answer);

        return count.isFishied();
    }

}
