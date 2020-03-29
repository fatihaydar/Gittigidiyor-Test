import com.gittigidiyor.base.BasePage;
import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.AddtoBasketPage;
import com.gittigidiyor.page.LoginAndRegisterPage;
import com.gittigidiyor.page.SearchPage;
import com.thoughtworks.gauge.Step;
import static com.gittigidiyor.base.BaseTest.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.Random;

public class SearchProduct {
    SearchPage searchPage;
    BaseTest baseTest;

    @Step("openPage")
    public void openPage() {
        try{
            searchPage = new SearchPage(getDriver());
        }catch (Exception e){
            searchPage.captureScreenshot("openPage");
            baseTest.tearDown();
        }

    }

    @Step("Arama kutusuna <urun> yaz")
    public void searchKey(String urun) {
        try {
            searchPage.sendKeys(By.id("search_word"), urun);
        }catch (Exception e){
            searchPage.captureScreenshot("Aramakutusunaurunyaz");
            baseTest.tearDown();
        }

    }

    @Step("Arama butonuna bas")
    public void clickSearchButton() {
        try {
            searchPage.clickElement(By.id("header-search-find-link"));
        }
        catch (Exception e){
            searchPage.captureScreenshot("AramabutonunaBas");
            baseTest.tearDown();

        }
    }


    @Step("<urun> araması kontrol edilir")
    public void SearchControl(String urun) {
        String productName;
        try {

            productName = searchPage.findElement(By.className("search-result-keyword")).getText();
            Assert.assertEquals(urun, productName);
        }
        catch(Exception e){
            searchPage.captureScreenshot("Urunkontrolhatasi");
            baseTest.tearDown();
        }




    }

    @Step("Arama sayfasından rasgele ürün seçilir")
    public void randomProductSelect() {
        try {
            Random rand = new Random();
            int random = rand.nextInt(45);
            String productName = searchPage.findElement(By.xpath(" /html/body/div[5]/div[2]/div/div[2]/div[4]/div[2]/ul/li[" + random + "]/a/div/div/div[1]/div[1]/h3/span")).getText();
            searchPage.clickElement(By.xpath("/html[1]/body[1]/div[5]/div[2]/div[1]/div[2]/div[4]/div[2]/ul[1]/li[" + random + "]"));
            String productNameAtDetail = searchPage.findElement(By.id("sp-title")).getText();
            Assert.assertEquals(productName,productNameAtDetail);
        }catch (Exception e){
            searchPage.captureScreenshot("Aramasayfasindanrasgeleurunsecilir");
            baseTest.tearDown();
        }

    }

    @Step("Seçilen ürün sepete eklenir")
    public void addToBasket() {
        try {
            searchPage.clickElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div[1]/div/div[10]/div[3]/section/div/div/div[2]/form/button/span"));
        }catch (Exception e){
            searchPage.captureScreenshot("Secilenurunsepeteeklenir");
            baseTest.tearDown();
        }
    }

    @Step("Kaç <quantity> sepete ekleneceği seçilir")
    public void selectQuantity(String quantity) {
        try {
            searchPage.sendKeys(By.id("buyitnow_adet"),quantity);

        }catch (Exception e){
         searchPage.captureScreenshot("Kacadetsepeteeklenecegisecilir");
         baseTest.tearDown();
        }



    }

}
