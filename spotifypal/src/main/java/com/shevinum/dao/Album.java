package com.shevinum.dao;

public record Album (
    String album_type,
    Integer total_tracks,
    String[] available_markets,
    ExternalUrls external_urls,
    String href,
    String id,
    Image[] images,
    String name,
    String release_date,
    String release_date_precision,
    Restrictions restrictions,
    String type,
    String uri,
    Copyright[] copyrights,
    ExternalId external_ids,
    String[] genres,
    String label,
    Integer popularity,
    String album_group,
    SimplifiedArtist[] artists
){}

