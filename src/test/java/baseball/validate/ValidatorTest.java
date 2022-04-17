package baseball.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void 기본설정() {
        validator = new Validator();
    }

    @ParameterizedTest
    @ValueSource(strings = { "111", "", "1234", "1", "One", "백", "101" })
    @DisplayName("예외발생되는되는 입력 값 테스트")
    void 예외발생되는되는_입력값_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validator.validate(number);
                });
    }

    @Test
    @DisplayName("빈값 체크하는 예외 테스트")
    void 빈값_체크_예외_테스트() {
        String number = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validator.nullOrEmptyCheck(number);
                })
                .withMessage("빈 값을 입력하였습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = { "1", "12", "1234" })
    @DisplayName("3자리 숫자가 아닌 예외 테스트")
    void 자릿수_체크_예외_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validator.fourLength(number);
                })
                .withMessage("3자리 숫자만 입력이 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나다", "One"})
    @DisplayName("1~9 숫자가 아닌 숫자가 들어왔을 때 예외 테스트")
    void 숫자가_아닌_입력_예외_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validator.numberCheck(number);
                })
                .withMessage("1~9가 아닌값이 들어왔습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "131", "311"})
    @DisplayName("중복시 예외 테스트")
    void 중복체크_예외_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validator.overlapCheck(number);
                })
                .withMessage("중복된 값은 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "3", "4" })
    @DisplayName("1과 2 이외의 예외가 되는지 테스트")
    void 일과이를_제외한_예외되는지_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validator.isOneOrTwo(number);
                })
                .withMessage("1과 2 이외에 다른 값이 들어왔습니다.");

    }

}
