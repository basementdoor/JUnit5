import com.google.search.POM.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // Добавь необходимые аннотации и аргументы
    @ParameterizedTest
    @CsvFileSource(resources = "/questionsDataTest.csv", numLinesToSkip = 0)
    public void allQuestionsHaveAnswerText(String question, String answer) {

        MainPage mainPage = new MainPage(driver);

        mainPage
                .openMain()
                .skipCookie()
                .scrollQuestionAndClick(question);

        assertTrue(mainPage.checkAnswer(answer), "Элемент не найден");


        // Здесь напиши логику открытия вопросов и проверки ответов
    }
} 