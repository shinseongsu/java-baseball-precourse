package baseball.view;

import baseball.constant.BaseballConstant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputofNumber() {
        ResultView.answerResult(BaseballConstant.INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String inputOfRestart() {
        ResultView.answerResult(BaseballConstant.INPUT_RESTART_MESSAGE);
        return Console.readLine();
    }

}
