package junit;

import com.codeborne.selenide.Selenide;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Этот метод выполняется перед всеми тестами");
    }

    @BeforeEach
    void openBrowser() {
        System.out.println("Этот метод выполняется перед каждым тестом");
        Selenide.open("https://google.com");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @Test
    void textTest() {
        //search by text
         }

    @Test
    void simpleTest() {
        //
        }
}