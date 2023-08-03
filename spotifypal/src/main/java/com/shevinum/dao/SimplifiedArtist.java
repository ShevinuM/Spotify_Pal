package com.shevinum.dao;

public record SimplifiedArtist (
    ExternalUrls external_urls,
    String href,
    String id,
    String name,
    String type,
    String uri
){}
