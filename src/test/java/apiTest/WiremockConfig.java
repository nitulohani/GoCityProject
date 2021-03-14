package apiTest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;


@Configuration
public class WiremockConfig {
    public static final String LOCATION_GET = "/location/get/";
    public static final String LOCATION_POST_ENDPOINT = "/location/post";
    private WireMockServer wireMockServer;

    @PostConstruct
    public void wiremockConfig() {
        if (wireMockServer == null) {
            int port = 8282;
            wireMockServer = new WireMockServer(options().port(port));
            WireMock.configureFor("localhost", port);
            wireMockServer.start();

            //for all locations
            stubFor(any(urlMatching("/location/get/all"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/all-locations.json"))
                    ));


            //for LON location
            stubFor(get(urlMatching(LOCATION_GET +  "LON"))
                    .willReturn(aResponse()
                           .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/lon-location.json"))));

            //for LCS location
            stubFor(get(urlMatching(LOCATION_GET +  "LCS"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/lcs-location.json"))));

            //for CAM location
            stubFor(get(urlMatching(LOCATION_GET +  "CAM"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/cam-location.json"))));

            //for MAN location
            stubFor(get(urlMatching(LOCATION_GET +  "CAM"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/man-location.json"))));


          /*  // default response to location
            stubFor(get(urlMatching("/location/get/" + ".*"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/default-all-location.json"))));*/

            //for creating a new location
            stubFor(post(urlMatching(LOCATION_POST_ENDPOINT ))
                     .withRequestBody(equalToJson("{ \n" +
                             "\"id\": \"1842347-1560779940\", \n" +
                             "\"cost\": \"£829.99\", \n" +
                             "\"location\": \"PAC\" \n" +
                             "} \n"))
                            .willReturn(aResponse().withStatus(200).withBody("PAC created successfully")));

            //for returning all locations with newly added Location PAC
            stubFor(any(urlMatching("/location/get/all"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/all-updated-locations.json"))
                    ));


            // Not found for USA location
            stubFor(get(urlMatching(LOCATION_GET + "USA"))
                    .willReturn(aResponse()
                            .withStatus(404)));

            // Not found for USA location
            stubFor(get(urlMatching(LOCATION_GET + "NEPAL"))
                    .willReturn(aResponse()
                            .withStatus(500)));

            // Not found for USA location
            stubFor(get(urlMatching(LOCATION_GET + "CANADA"))
                    .willReturn(aResponse()
                            .withStatus(503)));


        }
    }

    @PreDestroy
    void reset() {
        wireMockServer.stop();
    }
}