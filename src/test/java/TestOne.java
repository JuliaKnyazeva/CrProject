import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SerenityRunner.class)


class TestOne {

    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
            .setBaseUri("https://client.demo.crassu.la")
            .setBasePath("/api/public/authenticate")
            .setContentType(ContentType.JSON)
            .build();


    @Test
    public void createLoginNonFA1() {
        ValidatableResponse response;

        Login rq = new Login();
        rq.setUsername("QAno2FA@crassula.io");
        rq.setPassword("V85lPdks6cUm6#RM^Zd");

        CreateResponsJson rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().as(CreateResponsJson.class);



        assertThat(rs).isNotNull();

    }

    @Test
    public void createLoginNonFA2() {
        ValidatableResponse response;

        Login rq = new Login();
        rq.setUsername("QAno2FA@crassula.io");
        rq.setPassword(" ");

        Response rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when()
                .post()
                .then()
                .statusCode(401)
                .log().body()
                .extract().as(Response.class);

        String jsonString = rs.asString();

        assertThat(rs).isNotNull();

    }

    @Test
    public void createLoginNonFA3() {
        ValidatableResponse response;

        Login rq = new Login();
        rq.setUsername(" ");
        rq.setPassword("V85lPdks6cUm6#RM^Zd");

        Response rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when()
                .post()
                .then()
                .statusCode(401)
                .log().body()
                .extract().as(Response.class);

        String jsonString = rs.asString();

        assertThat(rs).isNotNull();

    }

    @Test
    public void createLoginNon2FA() {
        ValidatableResponse response;

        Login rq = new Login();
        rq.setUsername("QA2FA@crassula.io");
        rq.setPassword("fNn4FbZ9MCf*k9&m1c9");

        CreateResponsJson rs = given()
                .spec(REQ_SPEC)
                .body(rq)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().as(CreateResponsJson.class);



        assertThat(rs).isNotNull();

    }

    @Test
    public void getCreditCardToken() {

        given()
                .when()
                .get("https://api.demo.crassu.la/v1/card/getToken?project=d55ad89070d6172cc0eeeecfdde2c554&number=" +
                        "4012001037141112&expiration_month=3&expiration_year=2033&security_code=333")
                .then()
                .statusCode(200);

    }

    @Test
    public void createNewUser() {
        ValidatableResponse response;

        FirstUser newUserFirst = new FirstUser();
        newUserFirst.setSignature("1b3bc77bc5838251a7bc5a6e20f3711d59d340b7a3ea6e9bc175a750f464761a");
        newUserFirst.setProject("d55ad89070d6172cc0eeeecfdde2c554");
        newUserFirst.setIdentifier(1);
        newUserFirst.setIp("127.0.0.1");


        CreateResponsJson rs = given()
                .baseUri("https://client.demo.crassu.la")
                .basePath("/v1/user/resolve")
                .contentType(ContentType.JSON)
                .body(newUserFirst)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract().as(CreateResponsJson.class);



        assertThat(rs).isNotNull();

    }


}
