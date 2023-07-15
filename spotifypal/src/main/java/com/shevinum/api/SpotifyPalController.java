package com.shevinum.api;

/**
@RestController
public class SpotifyPalController {
    private final SpotifyPalService spotifyPalService;

    public SpotifyPalController(SpotifyPalService spotifyPalService) {
        this.spotifyPalService = spotifyPalService;
    }

    @PostMapping("/updateRecords")
    public void updateRecords() {
        spotifyPalService.updateRecords();
    }

    @PostMapping("/transferLikedSongs")
    public void transferLikedSongs() {
        spotifyPalService.transferLikedSongs();
    }

    @PostMapping("/compileMonthlySongs")
    public void compileMonthlySongs() {
        spotifyPalService.compileMonthlySongs();
    }

    @PostMapping("/compileArtistFavourites")
    public void compileArtistFavourites() {
        spotifyPalService.compileArtistFavourites();
    }

    @PostMapping("/reorderSongs")
    public void reorderSongs() {
        spotifyPalService.reorderSongs();
    }

    @PostMapping("compileYearlySongs")
    public void compileYearlySongs() {
        spotifyPalService.compileYearlySongs();
    }

    @PostMapping("createPersonalizedPlaylist")
    public void createPersonalizedPlaylist() {
        spotifyPalService.createPersonalizedPlaylist();
    }

    @PostMapping("createFavouritesPlaylist")
    public void createFavouritesPlaylist() {
        spotifyPalService.createFavouritesPlaylist();
    }

    @GetMapping("displayMonthlyStats")
    public void displayMonthlyStats() {
        spotifyPalService.displayMonthlyStats();
    }


}
**/