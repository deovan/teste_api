package gherkin.stepdefinition.web.home;

import br.com.pages.HomePage;
import br.com.report.ReporterUtils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

import java.util.List;

public class HomeSteps extends ReporterUtils {

    HomePage homePage = new HomePage();

    @Dado("que eu adicione produtos ao carrinho")
    public void queEuAdicioneProdutosAoCarrinho(List<String> produtos) {
        for (String produto : produtos) {
            homePage.adicionarProduto(produto);
            addScreenshotToReport("Adicionado produto " + produto);
            homePage.clicarEmContinueShopping();
            homePage.navigateToHome();
        }

    }

    @Quando("acesso o carrinho")
    public void acessoOCarrinho() {
        homePage.acessarCarrinho();
        addScreenshotToReport();
    }
}
