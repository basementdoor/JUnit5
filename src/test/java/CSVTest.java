import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVTest {

    public boolean isEven(int value) {
        if(value % 2 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isAdult(int value) {
        if(value >= 18){
            return true;
        }
        else {
            return false;
        }
    }

    @ParameterizedTest
    @CsvSource({
            "-5, false",
            "0, true",
            "1, false",
            "5, false"
    })
    public void isEvenForSomeValuesIsValid(int value, boolean result) { //тестовый метод для негативных сценариев
        assertEquals(result, isEven(value));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData.csv", numLinesToSkip = 0)
    void isAdultForBoundaryValuesIsValid(int age, boolean result) {
        assertEquals(result, isAdult(age));
    }
}