#language: pt

@ALL @CUSTOMER @WEB
Funcionalidade:  Efetuar compras
  História do Usuário #1:
  Como um cliente cadastrado no automationpractice.com
  Eu quero fazer a compra de ao menos dois produtos
  Para que eu possa me vestir melhor

  Contexto:
    Dado que eu acesso a url "http://automationpractice.com"
    E efetuo login com usuário "datumqatest@soprock.com" e senha "datum2021"

  Cenário: CT01 - Comprar dois produtos e efetuar o checkout
    Dado que eu adicione produtos ao carrinho
      | Faded Short Sleeve T-shirts |
      | Printed Dress               |
    Quando acesso o carrinho
    E prossigo o checkout até a etapa de Shipping
    E aceito os temos de entrega
    E prossigo o checkout
    Então devo selecionar o pagamento "Pay by check."
    E confirmar o pagamento
    Então deve exibir a snackBar com a mensagem "Your order on My Store is complete."
