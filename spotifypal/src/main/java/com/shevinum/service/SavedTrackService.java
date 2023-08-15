package com.shevinum.service;

import com.shevinum.dao.*;
import com.shevinum.model.SavedTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SavedTrackService {

    private SavedTrackRepository savedTrackRepository;
    private RestTemplate restTemplate;

    @Autowired
    public SavedTrackService(SavedTrackRepository savedTrackRepository, RestTemplate restTemplate) {
        this.savedTrackRepository = savedTrackRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * This method takes in the OAuth2AuthorizedClient, and uses it to make a request to the Spotify API to get the all
     * the saved tracks of the user.
     *
     *
     * @param client OAuth2AuthorizedClient passed from the controller
     * @return List of SavedTracksResponse
     * @throws RuntimeException
     */
    public List<SavedTracksResponse> getSavedTracks(OAuth2AuthorizedClient client) throws RuntimeException{
        String accessToken = client.getAccessToken().getTokenValue();

        List<SavedTracksResponse> allTracks = new ArrayList<>();

        String endpoint = "https://api.spotify.com/v1/me/tracks";

        do {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<SpotifyTracksResponse> response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, SpotifyTracksResponse.class);
            if (response.hasBody()) {
                SpotifyTracksResponse spotifyTracksResponse = response.getBody();
                allTracks.addAll(spotifyTracksResponse.items());
                endpoint = spotifyTracksResponse.next();
            } else {
                throw new RuntimeException("No body in response");
            }
        } while (endpoint != null);

        return allTracks;
    }

    /**
     * This method returns a list containing track audio features for each track in the list of track ids passed in.
     *
     * @param client OAuth2AuthorizedClient passed from the controller
     * @param trackIds List of track ids to get the audio features for
     * @return List of objects of type TrackAudioFeatures where each object represents the audio features for a single track
     */
    public List<AudioFeatures> getTrackAudioFeatures(OAuth2AuthorizedClient client, List<String> trackIds) {
        String accessToken = client.getAccessToken().getTokenValue();

        List<AudioFeatures> allTracks = new ArrayList<>();

        String baseEndpoint = "https://api.spotify.com/v1/audio-features";

        int startIndex = 0;
        int batchSize = 100;
        List<String> idBatch;
        String idParam;
        while (startIndex < trackIds.size()){
            // batch the id's into groups of 100
            idBatch = trackIds.subList(startIndex, Math.min(startIndex + batchSize, trackIds.size()));

            // join the 100 id's to a string
            idParam = String.join(",", idBatch);

            // join the id's to the endpoint
            String requestEndpoint = baseEndpoint + "?ids=" + idParam;

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<TracksAudioFeatures> response = restTemplate.exchange(requestEndpoint, HttpMethod.GET, entity, TracksAudioFeatures.class);
            if (response.hasBody()) {
                TracksAudioFeatures tracksAudioFeatures = response.getBody();
                AudioFeatures[] items = tracksAudioFeatures.audio_features();
                allTracks.addAll(Arrays.asList(items));
                startIndex += batchSize;
            } else {
                throw new RuntimeException("No body in response");
            }
        }
        return allTracks;
    }

    /**
     * This method takes in the OAuth2AuthorizedClient, and uses it to make a request to the Spotify API to get the all
     * the saved tracks of the user. 
     * @param client
     */
    public void updateSongs(OAuth2AuthorizedClient client) {
        List<SavedTracksResponse> trackResponses = getSavedTracks(client);
        List<String> trackIds = new ArrayList<>(); // to store the track ids to later on get the track features
        for (SavedTracksResponse trackResponse : trackResponses) {
            Track track = trackResponse.track();
            SavedTrack savedTrack = new SavedTrack(); // creating a new saved track entity object to save to DB
            savedTrack.setName(track.name());
            savedTrack.setUri(track.uri());
            savedTrack.setId(track.id());
            trackIds.add(track.id());
            savedTrack.setArtist_uri(track.artists()[0].uri()); // only adding the main artist
            savedTrack.setArtist_name(track.artists()[0].name()); // only adding the main artist
            savedTrack.setAdded_at(trackResponse.added_at());
        }
        List<AudioFeatures> trackAudioFeatures = getTrackAudioFeatures(client, trackIds);



    }
}
