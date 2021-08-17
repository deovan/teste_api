package br.com.pages;

import org.openqa.selenium.By;

import java.util.function.Function;

public class CheckoutPage extends GeralPage {

    private By buttonProceedToCheckout = By.cssSelector("p.cart_navigation a[title='Proceed to checkout']");
    private By buttonProceedToCheckoutInAddress = By.name("processAddress");
    private By buttonProceedToCheckoutInShipping = By.name("processCarrier");
    private By buttonConfirmOrder = By.cssSelector("#cart_navigation > button");
    private Function<String, By> linkTypePayment = (type) -> By.cssSelector("a[title='" + type + "']");
    private By checkboxAgreeTerms = By.id("uniform-cgv");

    public void clicarEmProceedToCheckout() {
        click(buttonProceedToCheckout);
    }

    public void aceitarTermosEntrega() {
        click(checkboxAgreeTerms);
    }

    public void selecionarPagamento(String formaPagamento) {
        click(linkTypePayment.apply(formaPagamento));
    }

    public void confirmarOrder() {
        click(buttonConfirmOrder);
    }

    public void clicarEmProceedToCheckoutInAddress() {
        click(buttonProceedToCheckoutInAddress);
    }

    public void clicarEmProceedToCheckoutInShipping() {
        click(buttonProceedToCheckoutInShipping);
    }

}
