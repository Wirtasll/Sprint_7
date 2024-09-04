import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class LoginCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI= "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void authenticationCourier () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"login\": \"iadzvnn\",\n" +
                        "    \"password\": \"1234\"\n" +
                        "}")
                .post("api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(200).body("id", is(378207));
    }
    @Test
    public void authenticationCourierError () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"login\": \"iadzvnn\",\n" +
                        "    \"password\": \"1231\"\n" +
                        "}")
                .post("api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(404).body("message", is("Учетная запись не найдена"));
    }
    @Test
    public void authenticationCourierNoPassword () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"password\": \"1234\"\n" +
                        "}")
                .post("api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(400).body("message", is("Недостаточно данных для входа"));
    }
    @Test
    public void authenticationFakeCourier () {
        given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "    \"login\": \"iazzzzvnn\",\n" +
                        "    \"password\": \"1234\"\n" +
                        "}")
                .post("api/v1/courier/login")
                .then()
                .assertThat()
                .statusCode(404).body("message", is("Учетная запись не найдена"));
    }

}