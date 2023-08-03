package com.shevinum.dao;

public record SavedTracksResponse (
    String added_at,
    Track track
){}
