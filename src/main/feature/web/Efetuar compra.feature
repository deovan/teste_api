#language: pt

@ALL @CUSTOMER @WEB
Funcionalidade:  Cadastrar novo Customer
  Eu como usuário desejo cadastrar um Customer e validar os dados salvos

  Contexto:
    Dado que eu acesso a url "http://automationpractice.com"
    E efetuo login com usuário "datumqatest@soprock.com" e senha "datum2021"

  Cenário: CT01 - Cadastrar novo Customer
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
