package it.suntravelrest.config;

import lombok.Data;

import java.util.List;

@Data
public class SearchResult
{
    private long hotelId;
    private String hotelName;
    private long contractId;
    private double markup;
    private String contractName;
    private List<SearchResultLine> resultLine;
}
