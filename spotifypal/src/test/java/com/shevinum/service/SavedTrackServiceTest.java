package com.shevinum.service;

import com.shevinum.dao.SavedTrackRepository;
import com.shevinum.dao.SpotifyTracksResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SavedTrackServiceTest {

    @Mock
    private SavedTrackRepository savedTrackRepository;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private OAuth2AuthorizedClient client;
    @InjectMocks
    private SavedTrackService savedTrackService;

    private ResponseEntity<SpotifyTracksResponse> mockedResponseEntity;


    @BeforeEach
    void setUp() {

        when(client.getAccessToken().getTokenValue()).thenReturn("test");
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(SpotifyTracksResponse.class))).thenReturn(new ResponseEntity<>(new SpotifyTracksResponse(), HttpStatus.OK)
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSavedTracksTest() {
    }

    @Test
    void getTrackAudioFeaturesTest() {
    }

    @Test
    void updateSongsTest() {
    }
}