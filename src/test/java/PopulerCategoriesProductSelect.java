import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.PopularCategoriesPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Random;

import static com.gittigidiyor.base.BaseTest.getDriver;

public class PopulerCategoriesProductSelect {

    PopularCategoriesPage popularCategoriesPage;
    BaseTest baseTest;

    @Step("Sayfa Açılır")
    public void openPage() {
        try {
            popularCategoriesPage = new PopularCategoriesPage(getDriver());

        }catch (Exception e){
            popularCategoriesPage.captureScreenshot("Sayfaacilir");
            baseTest.tearDown();
        }
    }

    @Step("Rasgele popüler kategoriye tiklanir")
    public void randomPopularCategorySelect() {
        try {
            Random rand = new Random();
            int random = rand.nextInt(5);
            random++;
            popularCategoriesPage.clickElement(By.cssSelector("div.gray-content:nth-child(5) div.container.home-page-widgets div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.mt20:nth-child(15) div.cover-frame div.gg-w-24.gg-d-24.gg-t-24.gg-m-24.item-container div.gg-w-4.gg-d-4.gg-t-8.gg-m-8.popular-categories-item:nth-child(" + random + ") a:nth-child(1) div.popular-categories-img-cont > img.lazyload-img"));
        }catch (Exception e){
            popularCategoriesPage.captureScreenshot("Rasgelepopulerkategoritikla");
            baseTest.tearDown();
        }
    }

    @Step("Açılan kategoriden rasgele bir ürün seçilir")
    public void randomProductSelect() {
        Random rand = new Random();
        int random;
        try {
            random = rand.nextInt(14);
            random++;
            popularCategoriesPage.clickElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[3]/div/ul/li["+ random +"]/a/div/p/img"));
        }catch (Exception e){
            popularCategoriesPage.captureScreenshot("Acilankategoridenrasgeleurunsecme");
            baseTest.tearDown();
        }
    }
}
