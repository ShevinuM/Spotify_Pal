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

    public SavedTrackService(SavedTrackRepository savedTrackRepository) {
        this.savedTrackRepository = savedTrackRepository;
    }

    public SpotifyTracksResponse getSavedTacks(OAuth2AuthorizedClient client) throws RuntimeException{
        String accessToken = client.getAccessToken().getTokenValue();
        RestTemplate restTemplate = new RestTemplate();
        String endpoint = "https://api.spotify.com/v1/me/tracks";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<SpotifyTracksResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, SpotifyTracksResponse.class);
        if (response.hasBody()) {
            SpotifyTracksResponse spotifyTracksResponse = response.getBody();
            return spotifyTracksResponse;
        } else {
            throw new RuntimeException("No body in response");
        }
    }
    public void updateSongs() {
    }
}
