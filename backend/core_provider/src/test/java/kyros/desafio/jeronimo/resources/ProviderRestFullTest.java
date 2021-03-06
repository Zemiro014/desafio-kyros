package kyros.desafio.jeronimo.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import kyros.desafio.jeronimo.factoryObject.BuildObject;
import kyros.desafio.jeronimo.web.ProviderRestFull;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.notNullValue;

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
                .body(notNullValue())
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
