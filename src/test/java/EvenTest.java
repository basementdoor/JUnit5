import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class EvenTest {

    public static Stream<Arguments> isEvenData() {
        return Stream.of( //метод передаёт данные для негативных сценариев
                arguments(-5, false),
                arguments(0, true),
                arguments(1, false),
                arguments(5, false)
        );
    }

    public boolean isEven(int value) {
        if(value % 2 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @ParameterizedTest
    @MethodSource("isEvenData")
    public void isEvenForSomeValuesIsValid(int value, boolean result) { //тестовый метод для негативных сценариев
        assertEquals(result, isEven(value));
    }
}