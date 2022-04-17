package baseball.controller;

import baseball.model.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BaseBallControllerTest {

    @ParameterizedTest
    @CsvSource(value = { "1|true", "2|false" }, delimiter = '|')
    void 입력값에_따라_재실행_되는지_테스트(String number, boolean answer) {
        BaseballController controller = new BaseballController();
        boolean result = controller.isRestart(number);

        assertThat(result).isEqualTo(answer);
    }

}
