package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

    private User user;

    @Test
    @DisplayName("정상된 입력값을 받았을 떄 테스트")
    void 입력값_테스트() {
        String number = "123";
        user = new User(number);

        assertThat(user.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("빈값 입력시 에외 테스트")
    void 빈값입력시_예외_테스트() {
        String number = "";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    user = new User(number);
                }).withMessage("빈 값을 입력하였습니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = { "1", "12", "1234" })
    @DisplayName("3자리가 아닌 입력값 예외 테스트")
    void 입력값_자릿수_예외_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    user = new User(number);
                }).withMessage("3자리 숫자만 입력이 가능합니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"101", "one", "백십이"})
    @DisplayName("1~9가 아닌 값이 들어오면 예외 처리")
    void 입력값_중_0_예외_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    user = new User(number);
                }).withMessage("1~9가 아닌값이 들어왔습니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"112", "211", "121", "111"})
    @DisplayName("중복된 값은 입력 할 수 없습니다.")
    void 중복된_값_예외_테스트(String number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    user = new User(number);
                }).withMessage("중복된 값은 입력할 수 없습니다.");
    }
    
}
