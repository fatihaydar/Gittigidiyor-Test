import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.LoginAndRegisterPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.gittigidiyor.base.BaseTest.getDriver;


public class LoginScenario {
    LoginAndRegisterPage LoginAndRegisterPage;
    BaseTest baseTest;

    @Step("Siteye git")
    public void setLanguageVowels() {
        try {
            LoginAndRegisterPage = new LoginAndRegisterPage(getDriver());

        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Siteyegit");
            baseTest.tearDown();
        }
    }

    @Step("Login sayfasını aç")
    public void openLoginPage() {
        try {
            LoginAndRegisterPage.hoverElement(By.className("robot-header-iconContainer-profile"));
            LoginAndRegisterPage.clickElement(By.id("SignIn"));
        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Loginsayfasiniac");
            baseTest.tearDown();
        }

    }

    @Step("Kullanıcı adı <kAdi> şifre <sifre> gir")
    public void setUsrnmandPass(String kAdi, String sifre) {
        try {
            LoginAndRegisterPage.sendKeys(By.id("L-UserNameField"), kAdi);
            LoginAndRegisterPage.sendKeys(By.id("L-PasswordField"), sifre);
        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Kullaniciadisifregir");

        }

    }

    @Step("Giriş butonuna tıkla")
    public void signIn() {
        try {
            LoginAndRegisterPage.clickElement(By.id("gg-login-enter"));

        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Girisbutonunatikla");
            baseTest.tearDown();
        }
    }

    @Step("Giris kontrolü yapılır")
    public void loginControl() {
        String myAccount = LoginAndRegisterPage.findElement(By.className("profile-page-name")).getText();
        Assert.assertEquals("Hesabım",myAccount);
    }
}
