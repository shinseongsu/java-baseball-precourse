package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputofNumber() {
        ResultView.answerResult("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public static String inputOfRestart() {
        ResultView.answerResult("게임을 새로 시작하려면 1, 종료하면 2를 입력해주세요.");
        return Console.readLine();
    }

}
