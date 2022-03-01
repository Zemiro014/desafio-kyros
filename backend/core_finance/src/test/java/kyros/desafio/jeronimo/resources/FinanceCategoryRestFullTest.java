package kyros.desafio.jeronimo.resources;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import kyros.desafio.jeronimo.factoryObject.BuilderObject;
import kyros.desafio.jeronimo.web.FinanceCategoryRestfull;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
@TestHTTPEndpoint(FinanceCategoryRestfull.class)
public class FinanceCategoryRestFullTest {

    @Test
    public void testFindAllCategories(){
        when().get()
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testFindCategoryById(){
        RestAssured.given()
                .when()
                .get("898eb6de-93cb-11ec-90d3-4b3312e0064d")
                .then()
                .statusCode(200)
                .body(is("{\"category\":\"Veículo\",\"id\":\"898eb6de-93cb-11ec-90d3-4b3312e0064d\"}"))
        ;
    }

    @Test
    public void testcreateCategory(){
        RestAssured.given()
                .contentType("application/json")
                .body(new BuilderObject().createCategoryObject())
                .when()
                .post()
                .then()
                .statusCode(201);
    }
}
