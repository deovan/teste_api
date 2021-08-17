package gherkin.stepdefinition.web.login;

import br.com.pages.HomePage;
import br.com.pages.LoginPage;
import br.com.report.ReporterUtils;
import cucumber.api.java.pt.E;

public class LoginSteps extends ReporterUtils {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @E("efetuo login com usuário {string} e senha {string}")
    public void efetuoLoginComUsuárioESenha(String username, String password) {
        homePage.clicarEmSignIn();
        addScreenshotToReport();
        loginPage.efetuarLogin(username, password);
        addScreenshotToReport();
        homePage.navigateToHome();
    }
}
