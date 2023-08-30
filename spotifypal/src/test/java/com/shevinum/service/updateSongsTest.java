package com.shevinum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shevinum.dao.*;
import com.shevinum.model.SavedTrack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class updateSongsTest {

    private String spotifyTracksResponse;
    private String tracksAudioFeaturesResponse;
    private List<SavedTracksResponse> savedTracks;
    private List<AudioFeatures> audioFeatures;
    @Mock
    private SavedTrackRepository savedTrackRepository;
    @Mock
    private OAuth2AuthorizedClient client;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private OAuth2AccessToken token;
    @InjectMocks
    private SavedTrackService savedTrackService;

    @BeforeEach
    void setUp() {
        spotifyTracksResponse = """
                {
                  "href": "https://api.spotify.com/v1/me/shows?offset=0&limit=20",
                  "limit": 20,
                  "next": null,
                  "offset": 0,
                  "previous": "https://api.spotify.com/v1/me/shows?offset=1&limit=1",
                  "total": 4,
                  "items": [
                    {
                      "added_at": "string",
                      "track": {
                        "album": {
                          "album_type": "compilation",
                          "total_tracks": 9,
                          "available_markets": [
                            "CA",
                            "BR",
                            "IT"
                          ],
                          "external_urls": {
                            "spotify": "string"
                          },
                          "href": "string",
                          "id": "2up3OPMp9Tb4dAKM2erWXQ",
                          "images": [
                            {
                              "url": "https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228",
                              "height": 300,
                              "width": 300
                            }
                          ],
                          "name": "string",
                          "release_date": "1981-12",
                          "release_date_precision": "year",
                          "restrictions": {
                            "reason": "market"
                          },
                          "type": "album",
                          "uri": "spotify:album:2up3OPMp9Tb4dAKM2erWXQ",
                          "copyrights": [
                            {
                              "text": "string",
                              "type": "string"
                            }
                          ],
                          "external_ids": {
                            "isrc": "string",
                            "ean": "string",
                            "upc": "string"
                          },
                          "genres": [
                            "Egg punk",
                            "Noise rock"
                          ],
                          "label": "string",
                          "popularity": 0,
                          "album_group": "compilation",
                          "artists": [
                            {
                              "external_urls": {
                                "spotify": "string"
                              },
                              "href": "string",
                              "id": "string",
                              "name": "string",
                              "type": "artist",
                              "uri": "string"
                            }
                          ]
                        },
                        "artists": [
                          {
                            "external_urls": {
                              "spotify": "string"
                            },
                            "followers": {
                              "href": "string",
                              "total": 0
                            },
                            "genres": [
                              "Prog rock",
                              "Grunge"
                            ],
                            "href": "string",
                            "id": "string",
                            "images": [
                              {
                                "url": "https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228",
                                "height": 300,
                                "width": 300
                              }
                            ],
                            "name": "string",
                            "popularity": 0,
                            "type": "artist",
                            "uri": "string"
                          }
                        ],
                        "available_markets": [
                          "string"
                        ],
                        "disc_number": 0,
                        "duration_ms": 0,
                        "explicit": false,
                        "external_ids": {
                          "isrc": "string",
                          "ean": "string",
                          "upc": "string"
                        },
                        "external_urls": {
                          "spotify": "string"
                        },
                        "href": "string",
                        "id": "string",
                        "is_playable": false,
                        "linked_from": {},
                        "restrictions": {
                          "reason": "string"
                        },
                        "name": "string",
                        "popularity": 0,
                        "preview_url": "string",
                        "track_number": 0,
                        "type": "track",
                        "uri": "string",
                        "is_local": false
                      }
                    }
                  ]
                }
                """;
        tracksAudioFeaturesResponse = """
                    {
                      "audio_features": [
                        {
                          "acousticness": 0.00242,
                          "analysis_url": "https://api.spotify.com/v1/audio-analysis/2takcwOaAZWiXQijPHIx7B",
                          "danceability": 0.585,
                          "duration_ms": 237040,
                          "energy": 0.842,
                          "id": "2up3OPMp9Tb4dAKM2erWXQ",
                          "instrumentalness": 0.00686,
                          "key": 9,
                          "liveness": 0.0866,
                          "loudness": -5.883,
                          "mode": 0,
                          "speechiness": 0.0556,
                          "tempo": 118.211,
                          "time_signature": 4,
                          "track_href": "https://api.spotify.com/v1/tracks/2takcwOaAZWiXQijPHIx7B",
                          "type": "audio_features",
                          "uri": "spotify:track:2takcwOaAZWiXQijPHIx7B",
                          "valence": 0.428
                        }
                      ]
                    }
                """;
        String endpoint1 = "https://api.spotify.com/v1/me/tracks";
        when(client.getAccessToken()).thenReturn(token);
        when(token.getTokenValue()).thenReturn("test");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SpotifyTracksResponse mappedSpotifyTracksResponse = objectMapper.readValue(spotifyTracksResponse,
                    SpotifyTracksResponse.class);
            when(restTemplate.exchange(eq(endpoint1), eq(HttpMethod.GET), any(), eq(SpotifyTracksResponse.class)))
                    .thenReturn(new ResponseEntity<>(mappedSpotifyTracksResponse, HttpStatus.OK));
            when(savedTrackService.getSavedTracks(client)).thenReturn(savedTracks);
            savedTracks = savedTrackService.getSavedTracks(client);
            ArrayList<String> tracksIds = new ArrayList<>();
            tracksIds.add("2up3OPMp9Tb4dAKM2erWXQ");
            TracksAudioFeatures mappedTracksAudioFeaturesResponse =
                    objectMapper.readValue(tracksAudioFeaturesResponse, TracksAudioFeatures.class);
            when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(TracksAudioFeatures.class)))
                    .thenReturn(new ResponseEntity<>(mappedTracksAudioFeaturesResponse, HttpStatus.OK));
            when(savedTrackService.getTrackAudioFeatures(client, tracksIds)).thenReturn(audioFeatures);
            audioFeatures = savedTrackService.getTrackAudioFeatures(client, tracksIds);
        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test
    void test1() {
        savedTrackService.updateSongs(client);
        ArgumentCaptor<SavedTrack> argumentCaptor = ArgumentCaptor.forClass(SavedTrack.class);
        verify(savedTrackRepository, atLeastOnce()).save(argumentCaptor.capture());
    }

}
