package io.project.app.order;

import com.netflix.discovery.EurekaClient;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public String getApiForData(String service, String api)  {
        ///  String defaultUrl = "http://consumer:2026/" + api;

        log.info("Try to get consumer metadata");
        String apiLink = String.format("%s%s", this.discoveryClient.getNextServerFromEureka(service, false).getHomePageUrl(), api);
        log.info("apiLink " + apiLink);

        return apiLink;
    }


    public String getOrder(String coffeeType) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.add("scope", "system");
        headers.add("client", "order");

        HttpEntity entity = new HttpEntity(headers);

        // the URL of preference
        String url = this.getApiForData("coffee", "/api/v2/coffee/build?coffeeType="+coffeeType);

        Try<ResponseEntity<String>> response = Try.of(() -> restTemplate.exchange(url, HttpMethod.GET, entity, String.class));

        if (response.isFailure()) {
            log.error("Request is fail!");
            log.error("Error response status code : " + response.get().getStatusCode());
            ////    log.error("Could not get data : " + response.getCause().getLocalizedMessage());
            return "fail";
        }

        if (response.isEmpty()) {
            log.error("Request is empty!");
            log.error("Error response status code : " + response.get().getStatusCode());
            ////    log.error("Could not get data : " + response.getCause().getLocalizedMessage());
            return "justempty";
        }

        if (response.isSuccess()) {
            log.info("Request is success");
            return response.get().getBody();
        }

        return "empty";
    }

    public String recover() {
        return "recover";
    }

    public String fallback(String service, String api, java.net.UnknownHostException e) {
        log.error("Failback ");

        return "failback";
    }
}
