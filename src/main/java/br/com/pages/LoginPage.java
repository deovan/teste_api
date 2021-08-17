package br.com.pages;

import org.openqa.selenium.By;

public class LoginPage extends GeralPage {

    private By inputEmail = By.id("email");
    private By inputPasswd = By.id("passwd");
    private By inputBack = By.name("back");
    private By buttonSubmitLogin = By.id("SubmitLogin");

    public void efetuarLogin(String username, String password) {
        sendKeys(inputEmail, username);
        sendKeys(inputPasswd, password);
        click(buttonSubmitLogin);
    }
}
