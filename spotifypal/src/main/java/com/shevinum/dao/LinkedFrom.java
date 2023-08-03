package com.shevinum.dao;

public record LinkedFrom (
    ExternalUrls external_urls,
    String href,
    String id,
    String type,
    String uri
){}
