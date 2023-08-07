package com.shevinum.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class tests the deserialization of sample Spotify JSON responses into SpotifyTracksResponse objects.
 */
public class SpotifyTracksResponseTest {

    @Test
    public void testMapping() throws IOException {
        //given
        String json = """
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

        // when
        ObjectMapper mapper = new ObjectMapper();
        SpotifyTracksResponse response;
        try {
            response = mapper.readValue(json, SpotifyTracksResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = mapper.readValue(json, SpotifyTracksResponse.class);


        //then
        assertThat(response.href()).isEqualTo("https://api.spotify.com/v1/me/shows?offset=0&limit=20");
        assertThat(response.limit()).isEqualTo(20);
        assertThat(response.next()).isEqualTo("https://api.spotify.com/v1/me/shows?offset=1&limit=1");
        assertThat(response.offset()).isEqualTo(0);
        assertThat(response.previous()).isEqualTo("https://api.spotify.com/v1/me/shows?offset=1&limit=1");
        assertThat(response.total()).isEqualTo(4);
        for (SavedTracksResponse item : response.items()) {
            assertThat(item.added_at()).isEqualTo("string");
            assertThat(item.track().album().album_type()).isEqualTo("compilation");
            assertThat(item.track().album().total_tracks()).isEqualTo(9);
            assertThat(item.track().album().available_markets()).containsExactly("CA", "BR", "IT");
            assertThat(item.track().album().external_urls().spotify()).isEqualTo("string");
            assertThat(item.track().album().href()).isEqualTo("string");
            assertThat(item.track().album().id()).isEqualTo("2up3OPMp9Tb4dAKM2erWXQ");
            for (Image image : item.track().album().images()) {
                assertThat(image.url()).isEqualTo("https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228");
                assertThat(image.height()).isEqualTo(300);
                assertThat(image.width()).isEqualTo(300);
            }
            assertThat(item.track().album().name()).isEqualTo("string");
            assertThat(item.track().album().release_date()).isEqualTo("1981-12");
            assertThat(item.track().album().release_date_precision()).isEqualTo("year");
            assertThat(item.track().album().restrictions().reason()).isEqualTo("market");
            assertThat(item.track().album().type()).isEqualTo("album");
            assertThat(item.track().album().uri()).isEqualTo("spotify:album:2up3OPMp9Tb4dAKM2erWXQ");
            for (Copyright copyright : item.track().album().copyrights()) {
                assertThat(copyright.text()).isEqualTo("string");
                assertThat(copyright.type()).isEqualTo("string");
            }
            assertThat(item.track().album().external_ids().isrc()).isEqualTo("string");
            assertThat(item.track().album().external_ids().ean()).isEqualTo("string");
            assertThat(item.track().album().external_ids().upc()).isEqualTo("string");
            assertThat(item.track().album().genres()).containsExactly("Egg punk", "Noise rock");
            assertThat(item.track().album().label()).isEqualTo("string");
            assertThat(item.track().album().popularity()).isEqualTo(0);
            assertThat(item.track().album().album_group()).isEqualTo("compilation");
            for (SimplifiedArtist artist : item.track().album().artists()) {
                assertThat(artist.external_urls().spotify()).isEqualTo("string");
                assertThat(artist.href()).isEqualTo("string");
                assertThat(artist.id()).isEqualTo("string");
                assertThat(artist.name()).isEqualTo("string");
                assertThat(artist.type()).isEqualTo("artist");
                assertThat(artist.uri()).isEqualTo("string");
            }
            for (Artist artist : item.track().artists()) {
                assertThat(artist.external_urls().spotify()).isEqualTo("string");
                assertThat(artist.followers().href()).isEqualTo("string");
                assertThat(artist.followers().total()).isEqualTo(0);
                assertThat(artist.genres()).containsExactly("Prog rock", "Grunge");
                assertThat(artist.href()).isEqualTo("string");
                assertThat(artist.id()).isEqualTo("string");
                for (Image image : artist.images()) {
                    assertThat(image.url()).isEqualTo("https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228");
                    assertThat(image.height()).isEqualTo(300);
                    assertThat(image.width()).isEqualTo(300);
                }
                assertThat(artist.name()).isEqualTo("string");
                assertThat(artist.popularity()).isEqualTo(0);
                assertThat(artist.type()).isEqualTo("artist");
                assertThat(artist.uri()).isEqualTo("string");
            }
            assertThat(item.track().available_markets()).containsExactly("string");
            assertThat(item.track().disc_number()).isEqualTo(0);
            assertThat(item.track().duration_ms()).isEqualTo(0);
            assertThat(item.track().explicit()).isEqualTo(false);
            assertThat(item.track().external_ids().isrc()).isEqualTo("string");
            assertThat(item.track().external_ids().ean()).isEqualTo("string");
            assertThat(item.track().external_ids().upc()).isEqualTo("string");
            assertThat(item.track().external_urls().spotify()).isEqualTo("string");
            assertThat(item.track().href()).isEqualTo("string");
            assertThat(item.track().id()).isEqualTo("string");
            assertThat(item.track().is_playable()).isEqualTo(false);
            assertThat(item.track().linked_from().external_urls()).isNull();
            assertThat(item.track().linked_from().href()).isNull();
            assertThat(item.track().linked_from().id()).isNull();
            assertThat(item.track().linked_from().type()).isNull();
            assertThat(item.track().linked_from().uri()).isNull();
            assertThat(item.track().restrictions().reason()).isEqualTo("string");
            assertThat(item.track().name()).isEqualTo("string");
            assertThat(item.track().popularity()).isEqualTo(0);
            assertThat(item.track().preview_url()).isEqualTo("string");
            assertThat(item.track().track_number()).isEqualTo(0);
            assertThat(item.track().type()).isEqualTo("track");
            assertThat(item.track().uri()).isEqualTo("string");
            assertThat(item.track().is_local()).isEqualTo(false);
        }
    }

}
