package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CountTest {

    @ParameterizedTest
    @CsvSource(value = {"123|136|1볼 1스트라이크", "145|589|1볼", "671|762|2볼", "713|713|3스트라이크"}, delimiter = '|')
    @DisplayName("스트라이크 볼 카운트 체크")
    void 스트라이크_볼_체크(String computerNumber, String countNumber, String answer) {
        // given
        Count count = new Count();

        // when
        String result = count.strikeOrBallCheck(computerNumber, countNumber);

        // then
        assertThat(answer).isEqualTo(answer);

    }

    @Test
    @DisplayName("3 스트라이크시 결과값 확인")
    void 전부_스트라이크시_참_반환하는지_테스트() {
        // given
        Count count = new Count();

        // then
        for(int i = 0 ; i <= 2 ; i++) {
            count.increaseStrike();
        }

        // when
        assertThat(count.isFishied()).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    @DisplayName("스트라이크가 몇개 있는지 확인")
    void 스트라이크_카운트가_있는지_테스트(int strikeCount) {
        // given
        String strike = "스트라이크";
        Count count = new Count();

        // when
        for(int i = 0 ; i < strikeCount ; i++) {
            count.increaseStrike();
        }
        String answer = strikeCount > 0 ? strikeCount + strike : "";

        // then
        assertThat( count.isStrike() ).isEqualTo(answer);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("볼이 몇개 있는지 확인")
    void 볼_카운트가_있는지_테스트(int ballCount) {
        // given
        String ball = "볼";
        String empty = " ";
        Count count = new Count();

        // when
        for(int i = 0 ; i < ballCount ; i++) {
            count.increaseBall();
        }
        String answer = ballCount > 0 ? ballCount + ball + empty : "";

        // then
        assertThat( count.isBallCount() ).isEqualTo(answer);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 낫싱_테스트() {
        Count count = new Count();

        assertThat(count.answer()).isEqualTo("낫싱");
    }

}
