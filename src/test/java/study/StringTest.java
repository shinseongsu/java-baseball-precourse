package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    // 요구사항1
    // 1. "1,2" 을 split했을 때, 1과 2로 잘 분리되는지 학습하는 테스트를 구현한다.
    @Test
    public void splitArrayTest() {
        String[] str = "1,2".split(",");

        assertThat(str).contains("1", "2");
        assertThat(str).containsExactly("1", "2");
    }

    // 2. "1'을 ,로 split했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    public void splitStringTest() {
        String[] str = "1".split(",");

        assertThat(str).contains("1");
        assertThat(str).containsExactly("1");
    }

    // 요구 사항2
    // "(1,2)"값이 주어졌을 떄 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    public void substringTest() {
        String str = "(1,2)";
        str = str.substring(1,str.length()-1);

        assertThat(str).isEqualTo("1,2");
    }

    // 요구 사항3
    // 1. "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // 2. String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
    //    StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    // 3. JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    @Test
    @DisplayName("assertThatThrownBy를 이용한 예외 처리 테스트")
    public void assertThatThrownByTest() {
        String str = "abc";

        assertThatThrownBy(() -> {  str.charAt(str.length()); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out");
    }

    @Test
    @DisplayName("assertThatExceptionOfType를 이용한 예외 처리 테스트")
    public void assertThatExceptionOfTypeTest() {
        String str = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(str.length());
                }).withMessageMatching("String index out of range: 3");
    }

}
