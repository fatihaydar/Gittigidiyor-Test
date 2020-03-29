import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.BestSellersPage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import static com.gittigidiyor.base.BaseTest.getDriver;

public class BestSellersOfTheWeek {
    BestSellersPage bestSellersPage;
    BaseTest baseTest;

    @Step("Anasayfa Açılır")
    public void openPage()
    {
        try {
            bestSellersPage = new BestSellersPage(getDriver());

        }catch (Exception e){
            bestSellersPage.captureScreenshot("Anasayfaacilir");
            baseTest.tearDown();
        }
    }


    @Step("Tüm Çok Satanlara Gider")
    public void seeThemAll() {
        try {
            bestSellersPage.clickElement(By.cssSelector("div.gray-content:nth-child(5) div.container.home-page-widgets div.gg-d-24.gg-t-24.gg-m-24.mt20.robot-homePage-mostSold-container:nth-child(13) div.gg-d-24.gg-t-24.gg-m-24.cover-frame div.gg-d-24.gg-t-24.hidden-m.cover-header:nth-child(2) div.right a:nth-child(1) p.see-all > span.hidden-m"));

        }catch (Exception e){
            bestSellersPage.captureScreenshot("Tumcoksatanlaragider");
            baseTest.tearDown();
        }
    }
}
