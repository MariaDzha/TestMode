import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestModeTest {
          private static RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9999)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        @Test
        void CreateValidUser() {
            given()
                    .spec(requestSpec)
                    .body(UserGenerator.createUser("vasya", "password", RegistrationDto.Status.active))
                    .when()
                    .post("/api/system/users")
                    .then()
                    .statusCode(200);

        }
    @Test
    void CreateUserWithInvalidLogin() {
        given()
                .spec(requestSpec)
                .body(UserGenerator.createUser("", "password", RegistrationDto.Status.active))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);

    }

    @Test
    void CreateUserWithInvalidPassword() {
        given()
                .spec(requestSpec)
                .body(UserGenerator.createUser("vasya", "", RegistrationDto.Status.active))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);

    }

    @Test
    void CreateUserWithStatusBlocked() {
        given()
                .spec(requestSpec)
                .body(UserGenerator.createUser("vasya", "password", RegistrationDto.Status.blocked))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);

    }
}
