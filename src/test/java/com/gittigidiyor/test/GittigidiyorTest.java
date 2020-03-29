package com.gittigidiyor.test;

import com.gittigidiyor.base.BaseTest;
import com.gittigidiyor.page.SearchPage;
import com.gittigidiyor.page.LoginAndRegisterPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class GittigidiyorTest extends BaseTest {
    SearchPage searchPage;
    LoginAndRegisterPage LoginAndRegisterPage;

    @Before
    public void before() {
        LoginAndRegisterPage = new LoginAndRegisterPage(getDriver());
    }

    //@Step("Login Sayfasina Gider")
    @Test
    public void openLoginPage() {
        LoginAndRegisterPage.hoverElement(By.className("robot-header-iconContainer-profile"));
        LoginAndRegisterPage.clickElement(By.id("SignIn"));


        /*
        searchPage.clickElement(POPUP_KAPAT);
        searchPage.writeInput(ARANACAK_URUN);
        searchPage.ClickSearch();
        searchPage.chooseProduct();
        searchPage.addBasket();
        String producktName = searchPage.getText(URUN_ADI);
        searchPage.goBasket();
        String basketName = searchPage.getText(SEPET_ADI);
        System.out.println(producktName + " - " + basketName);
        Assert.assertEquals(basketName, producktName);*/
    }
}
