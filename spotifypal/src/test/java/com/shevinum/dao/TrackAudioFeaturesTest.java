package com.shevinum.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test class is used to test the mapping of JSON response from endpoint https://api.spotify.com/v1/audio-features
 * to it's corresponding Java object 'TracksAudioFeatures'
 */
class TrackAudioFeaturesTest {

    @Test
    public void testMapping() throws IOException {
        //given
        String json = """
                {
                  "audio_features": [
                    {
                      "acousticness": 0.00242,
                      "analysis_url": "https://api.spotify.com/v1/audio-analysis/2takcwOaAZWiXQijPHIx7B",
                      "danceability": 0.585,
                      "duration_ms": 237040,
                      "energy": 0.842,
                      "id": "2takcwOaAZWiXQijPHIx7B",
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
        // when
        ObjectMapper mapper = new ObjectMapper();
        TracksAudioFeatures response;
        try {
            response = mapper.readValue(json, TracksAudioFeatures.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = mapper.readValue(json, TracksAudioFeatures.class);

        //then
        for (AudioFeatures item : response.audio_features()) {
            assertThat(item.acousticness()).isEqualTo(0.00242);
            assertThat(item.analysis_url()).isEqualTo("https://api.spotify.com/v1/audio-analysis/2takcwOaAZWiXQijPHIx7B");
            assertThat(item.danceability()).isEqualTo(0.585);
            assertThat(item.duration_ms()).isEqualTo(237040);
            assertThat(item.energy()).isEqualTo(0.842);
            assertThat(item.id()).isEqualTo("2takcwOaAZWiXQijPHIx7B");
            assertThat(item.instrumentalness()).isEqualTo(0.00686);
            assertThat(item.key()).isEqualTo(9);
            assertThat(item.liveness()).isEqualTo(0.0866);
            assertThat(item.loudness()).isEqualTo(-5.883);
            assertThat(item.mode()).isEqualTo(0);
            assertThat(item.speechiness()).isEqualTo(0.0556);
            assertThat(item.tempo()).isEqualTo(118.211);
            assertThat(item.time_signature()).isEqualTo(4);
            assertThat(item.track_href()).isEqualTo("https://api.spotify.com/v1/tracks/2takcwOaAZWiXQijPHIx7B");
            assertThat(item.type()).isEqualTo("audio_features");
            assertThat(item.uri()).isEqualTo("spotify:track:2takcwOaAZWiXQijPHIx7B");
            assertThat(item.valence()).isEqualTo(0.428);
        }
    }
}