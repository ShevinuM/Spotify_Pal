package com.shevinum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shevinum.dao.*;
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
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
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
    @Mock
    private OAuth2AccessToken token;
    @InjectMocks
    private SavedTrackService savedTrackService;

    private String testData1;
    private String testData2;
    private String tracksAudioFeatures;

    @BeforeEach
    void setUp() {
        testData1 = """
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
        testData2 = """
                {
                  "href": "https://api.spotify.com/v1/me/shows?offset=0&limit=20",
                  "limit": 20,
                  "next": "https://api.spotify.com/v1/me/tracks/next",
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

        when(client.getAccessToken()).thenReturn(token);
        when(token.getTokenValue()).thenReturn("test");
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test for getSavedTracks method.
     * This test checks that if given a valid response from the Spotify API, the method returns a list of SavedTracksResponse objects.
     * It does not handle the case where the next endpoint is not null.
     */
    @Test
    void checkForValidMappingToSavedTracksResponseNextNull() {
        try {
            // when
            ObjectMapper objectMapper = new ObjectMapper();
            SpotifyTracksResponse response;
            response = objectMapper.readValue(testData1, SpotifyTracksResponse.class);
            when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(SpotifyTracksResponse.class))).thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

            // then
            System.out.println(response.toString());
            assertThat(savedTrackService.getSavedTracks(client)).hasOnlyElementsOfType(SavedTracksResponse.class);

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }

    }

    /**
     * This test checks that if the response has an endpoint given at next, the SavedTracksResponse objects of that
     * endpoint are also returned. It checks the case where the next endpoint is not null.
     */
    @Test
    void getSavedTracksTestWhenNextNotNull() {
        // given
        String endpoint1 = "https://api.spotify.com/v1/me/tracks";
        String endpoint2 = "https://api.spotify.com/v1/me/tracks/next";
        try {
            // when
            ObjectMapper objectMapper = new ObjectMapper();
            SpotifyTracksResponse response1 = objectMapper.readValue(testData2, SpotifyTracksResponse.class);
            SpotifyTracksResponse response2 = objectMapper.readValue(testData1, SpotifyTracksResponse.class);
            when(restTemplate.exchange(eq(endpoint1), eq(HttpMethod.GET), any(), eq(SpotifyTracksResponse.class))).thenReturn(new ResponseEntity<>(response1, HttpStatus.OK));
            when(restTemplate.exchange(eq(endpoint2), eq(HttpMethod.GET), any(), eq(SpotifyTracksResponse.class))).thenReturn(new ResponseEntity<>(response2, HttpStatus.OK));

            // then
            assertThat(savedTrackService.getSavedTracks(client)).hasOnlyElementsOfType(SavedTracksResponse.class);
            assertThat(savedTrackService.getSavedTracks(client)).hasSize(2);

        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }


    /**
     * This test class checks that when a JSON is returned from the Spotify API, the method returns a list of
     * AudioFeatures objects.
     */
    @Test
    void getTrackAudioFeaturesTest() {
        StringBuilder tracksAudioFeatures = new StringBuilder();
        tracksAudioFeatures.append("""
                {
                  "audio_features": [
                 """);

        ArrayList<String> tracksIds = new ArrayList<>();
        for (int i=10000; i<10100; i++) {
            tracksIds.add(String.valueOf(i));
            tracksAudioFeatures.append(String.format("""
                    {
                      "acousticness": 0.00242,
                      "analysis_url": "https://api.spotify.com/v1/audio-analysis/2takcwOaAZWiXQijPHIx7B",
                      "danceability": 0.585,
                      "duration_ms": 237040,
                      "energy": 0.842,
                      "id": %s,
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
                    """, i));
            if (i < 10099) { // Only add a comma if it's not the last object
                tracksAudioFeatures.append(",");
            }
        }
        tracksAudioFeatures.append("""
                  ]
                }
                """);
        try {
            // when
            ObjectMapper objectMapper = new ObjectMapper();
            TracksAudioFeatures response = objectMapper.readValue(tracksAudioFeatures.toString(), TracksAudioFeatures.class);
            when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(TracksAudioFeatures.class))).thenReturn(new ResponseEntity<>(response, HttpStatus.OK));
            assertThat(savedTrackService.getTrackAudioFeatures(client, tracksIds)).hasOnlyElementsOfType(AudioFeatures.class);
            assertThat(savedTrackService.getTrackAudioFeatures(client, tracksIds)).hasSize(100);
        } catch (Exception e) {
            fail("Test failed due to exception: " + e.getMessage());
        }
    }

}