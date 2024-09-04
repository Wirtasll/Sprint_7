import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class CreatingCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI= "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void createCourier () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"login\": \"iadddzvnn\",\n" +
                        "    \"password\": \"1234\",\n" +
                        "    \"firstName\": \"saskee\"\n" +
                        "}")
                .post("api/v1/courier")
                .then()
                .assertThat()
                .statusCode(201).body("ok", is(true));
    }

    @Test
    public void createDublerCourier() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"login\": \"iadddzvnn\",\n" +
                        "    \"password\": \"1234\",\n" +
                        "    \"firstName\": \"saskee\"\n" +
                        "}")
                .post("api/v1/courier")
                .then()
                .assertThat()
                .statusCode(409).body("message", is("Этот логин уже используется. Попробуйте другой."));
    }

    @Test
    public void createCourierWithoutOneField() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"password\": \"1234\",\n" +
                        "    \"firstName\": \"saske\"\n" +
                        "}")
                .post("api/v1/courier")
                .then()
                .assertThat()
                .statusCode(400).body("message", is("Недостаточно данных для создания учетной записи"));
    }


}
