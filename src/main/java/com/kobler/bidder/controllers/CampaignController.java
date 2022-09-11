package com.kobler.bidder.controllers;

import com.kobler.bidder.domains.Campaign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for campaign related operations
 *
 * @author Deepak Mohan
 * @version 1.0
 * @since 11-09-2022
 *
 */
@RestController
public class CampaignController {

    @PostMapping("/campaigns")
    public List<Campaign> createCampaigns(Campaign campaign){

        return null;
    }

}
