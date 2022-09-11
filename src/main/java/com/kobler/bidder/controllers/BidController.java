package com.kobler.bidder.controllers;

import com.kobler.bidder.domains.Bid;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for the rest mapping of bidding api
 * This api is responsible for keyword to bid mapping
 *
 * @author Deepak Mohan
 * @version 1.0
 * @since 11-09-2022
 *
 */
@RestController
public class BidController {

    @PostMapping("/bids")
    public Bid createBid(@RequestBody Bid bid){

        return bid;
    }

}
