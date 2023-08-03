package com.shevinum.dao;

import java.util.List;

public record SpotifyTracksResponse (
    String href,
    int limit,
    String next,
    int offset,
    String previous,
    int total,
    List<SavedTracksResponse> items
){}
