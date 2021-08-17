package gherkin.stepdefinition.web.checkout;


import br.com.pages.CheckoutPage;
import br.com.report.ReporterUtils;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;

public class CheckoutSteps extends ReporterUtils {

    CheckoutPage checkoutPage = new CheckoutPage();

    @E("prossigo o checkout até a etapa de Shipping")
    public void prossigoOCheckoutAtéAEtapaDeShipping() {

        checkoutPage.clicarEmProceedToCheckout();
        addScreenshotToReport("Acessou Address");
        checkoutPage.clicarEmProceedToCheckoutInAddress();
        addScreenshotToReport("Acessou Shipping");
    }

    @E("aceito os temos de entrega")
    public void aceitoOsTemosDeEntrega() {
        checkoutPage.aceitarTermosEntrega();
        addScreenshotToReport();
    }

    @E("prossigo o checkout")
    public void prossigoOCheckout() {
        checkoutPage.clicarEmProceedToCheckoutInShipping();
        addScreenshotToReport("Acessou Payment");
    }

    @Então("devo selecionar o pagamento {string}")
    public void devoSelecionarOPagamento(String formaPagamento) {
        checkoutPage.selecionarPagamento(formaPagamento);
    }

    @E("confirmar o pagamento")
    public void confirmarOPagamento() {
        checkoutPage.confirmarOrder();
    }
}
