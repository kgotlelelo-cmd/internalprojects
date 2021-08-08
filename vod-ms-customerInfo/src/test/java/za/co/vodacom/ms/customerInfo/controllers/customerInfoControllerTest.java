package za.co.vodacom.ms.customerInfo.controllers;

import com.epages.wiremock.starter.WireMockTest;
import com.jayway.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.vodacom.ms.config.testing.VodMsRestAssuredTest;

import static com.jayway.restassured.RestAssured.given;
import static org.springframework.restdocs.cli.CliDocumentation.curlRequest;
import static org.springframework.restdocs.http.HttpDocumentation.httpRequest;
import static org.springframework.restdocs.http.HttpDocumentation.httpResponse;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("development")
@Slf4j
@WireMockTest(stubPath = "mappings")
public class customerInfoControllerTest extends VodMsRestAssuredTest {

    @LocalServerPort
    private void initPort(final int port) {
        RestAssured.port = port;
    }

    @Before
    public void setUp() {
        System.setProperty("za.co.vodacom.i18n.locale.language.default", "en");
        System.setProperty("za.co.vodacom.i18n.locale.country", "ZA");
        super.setUp();
    }

    @Test
    public void sayHelloTest() {
        given(this.requestSpecification)
            .filter(this.restDocumentationFilter.document(
                httpRequest(),
                httpResponse(),
                curlRequest(),
                relaxedResponseFields(
                    fieldWithPath("result").description("payload")
                ))
            )
            .accept("application/json")
            .header("Content-Type", "application/json")
            .get("public-services/tests/hello")
            .then()
            .log().all()
            .assertThat()
            .body("result.message", Matchers.is("Hello ,Welcome to Vodacom Cloud"))
            .and()
            .statusCode(200);
    }


    //Only works for prod url
//    @Test
//    public void getDetailsByMsisdn(){
//        given()
//                .when()
//                .get("public-services/tests/customer/0793070263")
//                .then()
//                .log().all()
//                .assertThat()
//                .statusCode(200);
//    }

    //Only works for nonprod url check application.yml service.props

    @Test
    public void getDetailsByMsisdn(){
        given()
                .when()
                .get("public-services/tests/customer/27630000455")
                .then()
                .log().all()
                .assertThat()
                .body("result.accountNumber",Matchers.is("1-53038487081"))
                .and()
                .statusCode(200);
    }

//    @Test
//    public void getDetailsByMsisdnBadRequest(){
//        given()
//                .when()
//                .get("public-services/tests/customer/27630000499")
//                .then()
//                .log().all()
//                .assertThat()
//                .statusCode(500);
//    }
}
