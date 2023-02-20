import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class CarDeliveryTest {

    @Test
    void testCarDelivery() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
       // Selenide.$x("//*[contains(text(),'Город')]").setValue("Майкоп");
    }


}
