package com.shevinum.service;

import com.shevinum.dao.SavedTrackRepository;
import com.shevinum.dao.SpotifyTracksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SavedTrackService {

    @Autowired
    private SavedTrackRepository savedTrackRepository;

    public void updateSongs(OAuth2AuthorizedClient client) {
        String accessToken = client.getAccessToken().getTokenValue();
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "https://api.spotify.com/v1/me/tracks";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<SpotifyTracksResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, SpotifyTracksResponse.class);
    }
}
