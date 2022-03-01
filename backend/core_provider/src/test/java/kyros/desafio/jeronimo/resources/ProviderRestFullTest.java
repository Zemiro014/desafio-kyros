package kyros.desafio.jeronimo.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import kyros.desafio.jeronimo.factoryObject.BuildObject;
import kyros.desafio.jeronimo.web.ProviderRestFull;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

import static io.restassured.RestAssured.when;

@QuarkusTest
@TestHTTPEndpoint(ProviderRestFull.class)
public class ProviderRestFullTest {


    @Test
    public void testFindAllProvider() {
        when().get()
                .then()
                .statusCode(200);
    }

    @Test
    public void testFindProviderById(){
        when().get("559fc752-9013-11ec-9d14-7ba22ebf1f9b")
                .then()
                .statusCode(200)
                .body(is("{\"cnpjCpf\":\"48633261000175\",\"email\":\"string03@gmail.com\",\"id\":\"559fc752-9013-11ec-9d14-7ba22ebf1f9b\",\"providerAddress\":{\"cep\":\"93210008\",\"city\":\"Novo Hamburgo\",\"id\":\"45deade8-9012-11ec-a0c6-a724ff393c9d\",\"number\":\"7015\",\"state\":\"RS\",\"street\":\"Rua Independência\"},\"providerName\":\"Musikada\",\"providerPhone\":\"5196857421\"}"))
        ;
    }
    @Test
    public void testCreateProvider(){
        RestAssured.given()
                .contentType("application/json")
                .body(new BuildObject().createProviderRequestTO())
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}
