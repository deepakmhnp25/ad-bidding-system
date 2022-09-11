package com.kobler.bidder.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bid {

    private String bidId;
    private List<String> keywords;
    private Integer bidAmount;

}
