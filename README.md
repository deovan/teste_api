# Testes Automatizados

Automação

## PRÉ-REQUISITOS

*   Java 1.8 SDK
*   Maven 3.5.*
*   Plugin do Cucumber
*   Plugin do Gherkin
*   Plugin do Lombok

## ESTRUTURA DO PROJETO

| Diretório                    	| finalidade       	                                                                                        | 
|------------------------------	|---------------------------------------------------------------------------------------------------------- |
| src\main\features         	| Funcionalidade e cenários de teste escritos em linguagem DSL (Gherkin language)                        	|   
| src\main\java\br.com.driver 			| Responsável por fabricar os drivers para rodar local e remoto para vários navegadores                    	|
| src\main\java\br.com.model 			| Responsável por fabricar massas de dados sintéticas                    	|
| src\main\java\br.com.pages			| Local onde deve ser criado as br.com.pages objects para facilitar a manutenção do projeto                       	|
| src\main\java\br.com.report			| Métodos responsáveis pela criação de screenshot e textos anexada no Report                                		|
| src\test\java\runner         	| Método principal que inicia os testes via cucumber                                                      	|
| src\test\java\gherkin\hooks   | Métodos que executam antes e depois de cada teste (@Before, @After)                                   	|
| src\test\java\gherkin\steps   | Local onde deve ser criado as classes que representam os steps definition do cucumber                    	|

  
## EXECUTANDO OS TESTES

```
 
Excutar o teste via maven:

           mvn clean verify -Dbrowser=chrome -Dcucumber.options="--tags @ALL"

Para gerar o report html quando executado os testes pela IDE, deve ser executado o comando:
        
            mvn cluecumber-report:reporting

O report gerado fica disponivel na pasta:

    target\generated-report\index.html
        
```

