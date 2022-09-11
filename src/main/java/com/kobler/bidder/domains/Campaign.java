package com.kobler.bidder.domains;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Campaign domain object
 *
 * @author Deepak Mohan
 * @version 1.0
 * @since 11-09-2022
 */
@Getter
@Setter
public class Campaign {

    private String name;
    private List<String> keywords;
    private Integer budget;
    private Integer spending;

}
