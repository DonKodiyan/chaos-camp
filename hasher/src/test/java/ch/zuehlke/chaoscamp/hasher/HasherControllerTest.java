package ch.zuehlke.chaoscamp.hasher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HasherControllerTest {

  @LocalServerPort
  int serverPort;

  @BeforeEach
  void setUp() {
    RestAssured.port = serverPort;
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
  }

  @Test
  public void hash_someValue_shouldMakeHaspiHappy() {
    // @formatter:off
    given()
        .queryParam("value", "blub")
    .when()
        .get("/api/hash")
    .then()
        .statusCode(200)
        .body("result", notNullValue());
    // @formatter:on

  }
}