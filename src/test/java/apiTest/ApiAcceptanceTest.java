package apiTest;

import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static apiTest.FileReader.readFile;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(
        classes = {apiTest.WiremockConfig.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class ApiAcceptanceTest {

    @Autowired
    private TestRestTemplate restTemplate;


    private ResponseEntity<String> endpointIsHit(String givenStartupURL) {
        return restTemplate.getForEntity(givenStartupURL, String.class);
    }

    @Test
    void shouldSuccessfullyReturnAllLocationsDetail() throws JSONException {
        ResponseEntity<String> response = endpointIsHit("http://localhost:8282/location/get/all");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        //MatcherAssert.assertThat(response.getBody(), containsString("hello all"));

        String expectedResponse = readFile("api-expected-response/expected-all-locations-response.json");
        assertEquals(expectedResponse, response.getBody(), true);
    }

    @Test
    void shouldSuccessfullyReturnDetailsForSpecificLocation() throws JSONException {
        ResponseEntity<String> response = endpointIsHit("http://localhost:8282/location/get/India");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        //MatcherAssert.assertThat(response.getBody(), containsString("hello all"));

        String expectedResponse = readFile("api-expected-response/default-all-location-response.json");
        assertEquals(expectedResponse, response.getBody(), true);
    }

    @Test
    void shouldReturnNotFoundForUSALocation() {
        ResponseEntity<String> response = endpointIsHit("http://localhost:8282/location/get/USA");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        /*String expectedResponse = readFile("api-expected-response/default-all-location-response.json");
        assertEquals(expectedResponse, response.getBody(), true);*/
    }

    @Test
    void shouldReturnInternalServerErrorForCanadaLocation() {
        ResponseEntity<String> response = endpointIsHit("http://localhost:8282/location/get/CANADA");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

        /*String expectedResponse = readFile("api-expected-response/default-all-location-response.json");
        assertEquals(expectedResponse, response.getBody(), true);*/
    }
}
