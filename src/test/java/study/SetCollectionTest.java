package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    // Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @Test
    @DisplayName("Set Size()값을 확인하는 테스트")
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(numbers.size());
        assertThat(numbers.size()).isNotEqualTo(numbers.size()-1);
    }

    // 요구사항2
    // 1. Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    // 2. 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
    // 3. Junit의 ParameterizedTest를 활용해 중복코드를 제거해 본다.
    @Test
    @DisplayName("원래 하던 방법으로 테스트")
    public void setConainsTest() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest를 사용하여 중복 제거 하기")
    public void setContainsOfParameterizedTest(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }


    // 요구사항 3
    // 1. 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
    //    입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    // 2. 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false가 반환되는 테스트를 하나의 Test Code로 구현한다.
    @ParameterizedTest
    @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
    public void setContainsOfCsvSource(int value, boolean result) {
        assertThat(numbers.contains(value)).isEqualTo(result);
    }

}