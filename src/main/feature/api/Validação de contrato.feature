#language: pt

@ALL @API @SCHEMA
Funcionalidade:  Validação de contrato
  Desenvolva, da maneira que achar mais adequada, a automação de testes para a
  API cuja documentação está descrita no site (https://reqres.in/).
  O projeto deve conter, pelo menos, um cenário para cada um dos seguintes métodos do
  endpoint USERS:
  A. Valide o método POST
  B. Valide o método GET SINGLE USER
  CENÁRIOS BÔNUS:
  C. Valide o método GET LIST USERS
  D. Valide o método PATCH

  Esquema do Cenário: Validar schema do contrato <nome>
    Dado que eu defina o endpoint "<endpoint>"
    Quando o serviço é consultado
    Então deve retornar o status "<status>"
    E é retornado o schema "<pathSchema>"
    Exemplos:
      | nome                      | endpoint     | status | pathSchema                     |
      | LIST USERS                | users?page=2 | 200    | list-users.json                |
      | SINGLE USER               | users/2      | 200    | single-user.json               |
      | SINGLE USER NOT FOUND     | users/23     | 404    | single-user-not-found.json     |
      | LIST RESOURCE             | unknown      | 200    | list-resource.json             |
      | SINGLE RESOURCE           | unknown/2    | 200    | single-resource.json           |
      | SINGLE RESOURCE NOT FOUND | unknown/23   | 404    | single-resource-not-found.json |