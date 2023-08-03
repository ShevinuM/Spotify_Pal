package com.shevinum.dao;

public record Artist (
    ExternalUrls external_urls,
    Followers followers,
    String[] genres,
    String href,
    String id,
    Image[] images,
    String name,
    Integer popularity,
    String type,
    String uri
){}
