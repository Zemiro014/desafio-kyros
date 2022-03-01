package kyros.desafio.jeronimo.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import kyros.desafio.jeronimo.factoryObject.BuilderObject;
import kyros.desafio.jeronimo.web.FinanceRestfull;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
@TestHTTPEndpoint(FinanceRestfull.class)
public class FinanceRestFullTest {

    @Test
    public void testFindAllFinances(){
        when().get()
                .then()
                .statusCode(200)
                .body(notNullValue())
        ;
    }

    @Test
    public void testFindFinanceById(){
        when().get("f5e730ac-8f9f-11ec-862d-4f03b7c947d2")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testCreatefinance(){
        RestAssured.given()
                .contentType("application/json")
                .body(new BuilderObject().createFinance())
                .when()
                .post()
                .then()
                .statusCode(201);
    }

}
