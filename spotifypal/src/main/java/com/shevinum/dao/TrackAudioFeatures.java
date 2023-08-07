package com.shevinum.dao;

public record TrackAudioFeatures (
        Float acousticness,
        String analysis_url,
        Float danceability,
        Integer duration_ms,
        Float energy,
        String id,
        Float instrumentalness,
        Integer key,
        Float liveness,
        Float loudness,
        Integer mode,
        Float speechiness,
        Float tempo,
        Integer time_signature,
        String track_href,
        String type,
        String uri,
        Float valence
){}
