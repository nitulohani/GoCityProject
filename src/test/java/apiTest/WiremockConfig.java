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
    public static final String LOCATION_ENDPOINT = "/location/get/";
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

            // default response to location
            stubFor(get(urlMatching("/location/get/" + ".*"))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody(FileReader.readFile("api_mock_response/default-all-location.json"))));

            // Not found for USA location
            stubFor(get(urlMatching(LOCATION_ENDPOINT + "USA"))
                    .willReturn(aResponse()
                            .withStatus(404)));

            // Not found for USA location
            stubFor(get(urlMatching(LOCATION_ENDPOINT + "NEPAL"))
                    .willReturn(aResponse()
                            .withStatus(500)));

            // Not found for USA location
            stubFor(get(urlMatching(LOCATION_ENDPOINT + "CANADA"))
                    .willReturn(aResponse()
                            .withStatus(503)));

        }
    }

    @PreDestroy
    void reset() {
        wireMockServer.stop();
    }
}