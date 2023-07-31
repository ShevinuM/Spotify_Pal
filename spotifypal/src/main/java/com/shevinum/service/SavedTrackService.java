package com.shevinum.service;

import com.shevinum.dao.SavedTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;

@Service
public class SavedTrackService {

    @Autowired
    private SavedTrackRepository savedTrackRepository;

    public void updateSongs(OAuth2AuthorizedClient client) {
        String accessToken = client.getAccessToken().getTokenValue();
    }
}
