package com.shevinum.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shevinum.dao.SavedTrackRepository;
import com.shevinum.dao.SavedTracksResponse;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    private String testData1;

    @BeforeEach
    void setUp() {
        String testData1 = """
                {
                  "href": "https://api.spotify.com/v1/me/shows?offset=0&limit=20",
                  "limit": 20,
                  "next": "https://api.spotify.com/v1/me/shows?offset=1&limit=1",
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
        when(client.getAccessToken().getTokenValue()).thenReturn("test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSavedTracksTest1() {
        // when
        ObjectMapper objectMapper = new ObjectMapper();
        SpotifyTracksResponse response;
        try {
            response = objectMapper.readValue(testData1, SpotifyTracksResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response = objectMapper.readValue(testData1, SpotifyTracksResponse.class);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(SpotifyTracksResponse.class))).thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        // then
        assertThat(savedTrackService.getSavedTracks(client)).hasOnlyElementsOfType(SavedTracksResponse.class);
    }

    @Test
    void getTrackAudioFeaturesTest() {
    }

    @Test
    void updateSongsTest() {
    }
}