package gherkin.stepdefinition.api;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;

public class ApiSteps {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT = "https://reqres.in/api/";

    @Quando("o serviço é consultado")
    public void oServiçoÉConsultado() {
        response = request.get();
    }

    @Dado("que eu defina o endpoint {string}")
    public void queEuDefinaOEndpoint(String path) {
        request = given()
                .relaxedHTTPSValidation()
                .baseUri(ENDPOINT.concat(path)).when();
    }

    @Então("é retornado o objeto")
    public void éRetornadoOObjeto(Map<String, String> responseFields) {
        json = response.then();
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                json.body(field.getKey(), hasToString(field.getValue()));
            }
        }
    }

    @Então("deve retornar o status {string}")
    public void deveRetornarOStatus(String status) {
        json = response.then().statusCode(Integer.parseInt(status));
    }

    @E("é retornado o schema {string}")
    public void éRetornadoOSchema(String nameSchema) {
        json = response.then();
        json.body(matchesJsonSchemaInClasspath(nameSchema));
    }
}
