import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.beans.PropertyEditor;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CarDeliveryTest {
    private String createDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void testCarDelivery() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $(("[data-test-id='city'] input")).setValue("Майкоп");
        String currentDate = createDate(3, "dd.MM.yyyy");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id='date'] input").setValue(currentDate);
        $("[data-test-id='name'] input").setValue("Кот Матроскин");
        $("[data-test-id='phone'] input").setValue("+79444987688");
        $("[data-test-id='agreement']").click();
        $x("//span[contains(text(),'Забронировать')]").click();
        $x("//div[contains(text(),'Встреча успешно забронирована на')]")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно забронирована на " + currentDate));


    }


}
