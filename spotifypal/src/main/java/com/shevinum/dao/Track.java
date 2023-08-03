package com.shevinum.dao;

public record Track (
    Album album,
    Artist[] artists,
    String[] available_markets,
    Integer disc_number,
    Integer duration_ms,
    boolean explicit,
    ExternalId external_ids,
    ExternalUrls external_urls,
    String href,
    String id,
    boolean is_playable,
    LinkedFrom linked_from,
    Restrictions restrictions,
    String name,
    Integer popularity,
    String preview_url,
    Integer track_number,
    String type,
    String uri,
    Boolean is_local
){}
