package com.shevinum.api;


import com.shevinum.service.SavedTrackService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyPalController {

    private final SavedTrackService savedTrackService;

    public SpotifyPalController(SavedTrackService savedTrackService) {
        this.savedTrackService = savedTrackService;
    }

    @PostMapping("/updateRecords")
    public void updateRecords(@RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient client) {
        savedTrackService.updateSongs(client);
    }


    @PostMapping("/transferLikedSongs")
    public void transferLikedSongs() {

    }

    @PostMapping("/compileMonthlySongs")
    public void compileMonthlySongs() {

    }

    @PostMapping("/compileArtistFavourites")
    public void compileArtistFavourites() {

    }

    @PostMapping("/reorderSongs")
    public void reorderSongs() {

    }

    @PostMapping("compileYearlySongs")
    public void compileYearlySongs() {

    }

    @PostMapping("createPersonalizedPlaylist")
    public void createPersonalizedPlaylist() {

    }

    @PostMapping("createFavouritesPlaylist")
    public void createFavouritesPlaylist() {

    }

    @GetMapping("displayMonthlyStats")
    public void displayMonthlyStats() {

    }


}

