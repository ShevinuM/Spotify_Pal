package com.shevinum.dao;

public record AudioFeatures(
        Double acousticness,
        String analysis_url,
        Double danceability,
        Integer duration_ms,
        Double energy,
        String id,
        Double instrumentalness,
        Integer key,
        Double liveness,
        Double loudness,
        Integer mode,
        Double speechiness,
        Double tempo,
        Integer time_signature,
        String track_href,
        String type,
        String uri,
        Double valence
){}
