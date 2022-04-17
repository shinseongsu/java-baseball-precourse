package baseball.util;

import baseball.uitl.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class RandomUtilTest {

    @ParameterizedTest(name = "{index}번째 랜덤 값을 만듭니다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9 })
    @DisplayName("중복된 값이 있는지 확인합니다.")
    void 랜덤값_만들기() {
        // given
        String randomNumber = RandomUtil.create();

        // when
        Set<String> set = new HashSet<String>();
        for(int i = 0 ; i < randomNumber.length() ; i++) {
            set.add(String.valueOf(randomNumber.charAt(i)));
        }

        // given
        assertThat(set.size()).isEqualTo(3);
    }

    @ParameterizedTest()
    @CsvSource(value = {"123|true", "171|false", "112|false", "311|false"}, delimiter = '|')
    void set값_파싱(String number, boolean result) {
        // given
        String[] strArr = number.split("");
        Set set = new HashSet();

        // given
        for(int i = 0 ; i < strArr.length ; i++) {
            set.add(strArr[i]);
        }

        // when
        assertThat(number.equals(RandomUtil.setOfString(set))).isEqualTo(result);
    }

}
