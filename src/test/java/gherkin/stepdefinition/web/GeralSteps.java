package gherkin.stepdefinition.web;

import br.com.pages.GeralPage;
import br.com.report.ReporterUtils;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;


public class GeralSteps extends ReporterUtils {

    GeralPage geralPage = new GeralPage();

    @Entao("deve exibir a snackBar com a mensagem {string}")
    public void deveExibirASnackBarComAMensagem(String msg) {
        geralPage.validaMensagemSnackBar(msg);
    }

    @E("deve exibir o box com a mensagem {string}")
    public void deveExibirOBoxComAMensagem(String mensagemBox) {
        geralPage.validaMensagemBox(mensagemBox);
    }

    @Dado("que eu acesso a url {string}")
    public void queEuAcessoAUrl(String arg0) {
        resetDriver(arg0);
    }

}
