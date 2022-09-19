package com.kobler.bidder;

import com.kobler.bidder.domain.Campaign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

/**
 * Integration test cases for Campaign related operations
 */
@SpringBootTest(classes = BidderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CampaignIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    /**
     * This should create the campaign and
     * return created id
     */
    @Test
    void testCampaignCreation(){

        ResponseEntity<Campaign> campaignResponseEntity = this.testRestTemplate.postForEntity("http://localhost:" + port + "/campaigns", createCampaignRequest(), Campaign.class);

        // status should be created
        Assertions.assertEquals(campaignResponseEntity.getStatusCode(), HttpStatus.CREATED);
        // should return the location id
        Assertions.assertNotNull(campaignResponseEntity.getHeaders().getLocation());

    }

    /**
     * This should fail on empty campaign input values
     */
    @Test
    void shouldFailOnEmptyMandatoryInputParams(){
        ResponseEntity<Campaign> campaignResponseEntity = this.testRestTemplate.postForEntity("http://localhost:" + port + "/campaigns", new Campaign(), Campaign.class);
        Assertions.assertEquals(campaignResponseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private static Campaign createCampaignRequest() {
        Campaign campaignRequest = new Campaign();
        campaignRequest.setBudget(100);
        campaignRequest.setName("Test");
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("kobler");
        campaignRequest.setKeywords(keywords);
        return campaignRequest;
    }
}
