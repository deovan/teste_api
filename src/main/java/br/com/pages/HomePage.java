package br.com.pages;

import org.openqa.selenium.By;

import java.util.function.Function;

public class HomePage extends GeralPage {

    private By linkLogin = By.cssSelector("a.login");
    private By buttonAddToCart = By.cssSelector("#add_to_cart > button");
    private By buttonContinueToShopping = By.cssSelector("span[title='Continue shopping']");
    private By linkHome = By.cssSelector("a[title='My Store']");
    private By linkCarrinho = By.cssSelector("a[title='View my shopping cart']");
    private Function<String, By> produto = (title) -> By.cssSelector("a[title='" + title + "']");

    public void clicarEmSignIn() {
        click(linkLogin);
    }

    public void adicionarProduto(String produtoName) {
        click(produto.apply(produtoName));
        click(buttonAddToCart);
    }

    public void navigateToHome() {
        click(linkHome);
    }

    public void clicarEmContinueShopping() {
        click(buttonContinueToShopping);
    }

    public void acessarCarrinho() {
        click(linkCarrinho);
    }
}
