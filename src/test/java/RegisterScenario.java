import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.LoginAndRegisterPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.gittigidiyor.base.BaseTest.getDriver;

public class RegisterScenario {
    LoginAndRegisterPage LoginAndRegisterPage;
    BaseTest baseTest;

    @Step("Open Main Page")
    public void openMaingPage() {
        try {
            LoginAndRegisterPage = new LoginAndRegisterPage(getDriver());
        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Openmainpage");
            baseTest.tearDown();
        }
    }

    @Step("Open Register Page")
    public void openRegisterPage() {
        try {
            LoginAndRegisterPage.hoverElement(By.className("robot-header-iconContainer-profile"));
            LoginAndRegisterPage.clickElement(By.id("SignUp"));
        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Openregisterpage");
            baseTest.tearDown();
        }

    }

    @Step("register name <name>, surname <surname>, email <email>, password <passwd>, gsm no <gsmData>")
    public void register(String name, String surname, String email, String passwd, String gsmData) {
        try {
            LoginAndRegisterPage.sendKeys(By.name("name"), "name");
            LoginAndRegisterPage.sendKeys(By.name("surname"), "surname");
            LoginAndRegisterPage.sendKeys(By.name("email"), "email");
            LoginAndRegisterPage.sendKeys(By.name("passwd"), "passwd");
            LoginAndRegisterPage.sendKeys(By.name("gsmData"), "gsmData");

        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Registerinformation");
            baseTest.tearDown();
        }

    }

    @Step("Click Register Button")
    public void ClickRegisterButton() {
        try {
            LoginAndRegisterPage.clickElement(By.id("SubmitForm"));

        } catch (Exception e) {
            LoginAndRegisterPage.captureScreenshot("Clickregisterbutton");
            baseTest.tearDown();
        }
    }

    @Step("Kayıt olma kontrolü yapılır")
    public void registerControl() {
        String myAccount = LoginAndRegisterPage.findElement(By.className("profile-page-name")).getText();
        Assert.assertEquals("Hesabım",myAccount);
    }
}
