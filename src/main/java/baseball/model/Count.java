package baseball.model;

import baseball.view.ResultView;

public class Count {
    private int ball;
    private int strike;

    public Count() {
        this.ball = 0;
        this.strike = 0;
    }

    public void increaseBall() {
        this.ball++;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public String strikeOrBallCheck(String ComputerNumber, String UserNumber) {
        for(int i = 0 ; i < UserNumber.length() ; i++) {
            int index = ComputerNumber.indexOf(UserNumber.charAt(i));
            if( i == index) {
                this.increaseStrike();
                continue;
            }
            if( index >= 0) this.increaseBall();
        }
        return answer();
    }

    public boolean isFishied() {
        if(this.strike == 3) {
            ResultView.answerResult("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public String answer() {
        return isNotthing(isBallCount() + isStrike());
    }

    public String isBallCount() {
        return this.ball > 0 ? this.ball + "볼 " : "";
    }

    public String isStrike() {
        return this.strike > 0 ? this.strike + "스트라이크" : "";
    }

    public String isNotthing(String result) {
        return "".equals(result) ? "낫싱" : result;
    }

}
