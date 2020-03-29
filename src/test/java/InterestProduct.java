import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.InterestPage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import java.util.Random;

import static com.gittigidiyor.base.BaseTest.getDriver;

public class InterestProduct {
    InterestPage interestPage;
    BaseTest baseTest;

    @Step("AnaSayfa Açılır")
    public void openPage() {
        try {
            interestPage = new InterestPage(getDriver());

        }catch (Exception e){
            interestPage.captureScreenshot("Anasayfaacilir");
            baseTest.tearDown();
        }
    }

    @Step("Rasgele Ürün Seçilir")
    public void randomProductSelect() {
        Random rand = new Random();
        int rand1;
        int rand2;
        try {
            rand1 = rand.nextInt(4);
            rand2 = rand.nextInt(4);
            rand1++;
            rand2++;
            interestPage.clickElement(By.xpath("/html/body/div[5]/div[1]/div[17]/div/div[2]/ul/ul["+ rand1 +"]/li["+ rand2 +"]/a/div/div/div[1]/img"));
        }catch (Exception e){
            interestPage.captureScreenshot("Rasgeleurunsecilir");
            baseTest.tearDown();
        }

    }
}
