import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class CreatingOrderTest {
    @Before
    public void setUp() {
        RestAssured.baseURI= "https://qa-scooter.praktikum-services.ru/";
    }
    @Test
    public void creatingOrderBlack () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"firstName\": \"Naruto\",\n" +
                        "    \"lastName\": \"Uchiha\",\n" +
                        "    \"address\": \"Konoha, 142 apt.\",\n" +
                        "    \"metroStation\": 4,\n" +
                        "    \"phone\": \"+7 800 355 35 35\",\n" +
                        "    \"rentTime\": 5,\n" +
                        "    \"deliveryDate\": \"2020-06-06\",\n" +
                        "    \"comment\": \"Saske, come back to Konoha\",\n" +
                        "    \"color\": [\n" +
                        "        \"BLACK\"\n" +
                        "    ]\n" +
                        "}")
                .post("api/v1/orders")
                .then()
                .statusCode(201);
    }
    @Test
    public void creatingOrderGrey () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"firstName\": \"Naruto\",\n" +
                        "    \"lastName\": \"Uchiha\",\n" +
                        "    \"address\": \"Konoha, 142 apt.\",\n" +
                        "    \"metroStation\": 4,\n" +
                        "    \"phone\": \"+7 800 355 35 35\",\n" +
                        "    \"rentTime\": 5,\n" +
                        "    \"deliveryDate\": \"2020-06-06\",\n" +
                        "    \"comment\": \"Saske, come back to Konoha\",\n" +
                        "    \"color\": [\n" +
                        "        \"GREY\"\n" +
                        "    ]\n" +
                        "}")
                .post("api/v1/orders")
                .then()
                .statusCode(201);
    }
    @Test
    public void creatingOrderNoColor () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"firstName\": \"Naruto\",\n" +
                        "    \"lastName\": \"Uchiha\",\n" +
                        "    \"address\": \"Konoha, 142 apt.\",\n" +
                        "    \"metroStation\": 4,\n" +
                        "    \"phone\": \"+7 800 355 35 35\",\n" +
                        "    \"rentTime\": 5,\n" +
                        "    \"deliveryDate\": \"2020-06-06\",\n" +
                        "    \"comment\": \"Saske, come back to Konoha\"\n" +
                        "}")
                .post("api/v1/orders")
                .then()
                .statusCode(201);
    }
}
