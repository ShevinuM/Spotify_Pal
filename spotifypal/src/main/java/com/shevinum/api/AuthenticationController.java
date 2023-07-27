package com.shevinum.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;

public class AuthenticationController {
    private String spotify_client_id;
    private String spotify_client_secret;
    private String redirect_url;
    private String scope;

    public AuthenticationController() {
        this.spotify_client_id = System.getenv("SPOTIFY_CLIENT_ID");
        this.spotify_client_secret = System.getenv("SPOTIFY_CLIENT_SECRET");
        this.redirect_url = "http://localhost:8080/";
        this.scope = "user-read-private user-read-email playlist-read-private playlist-read-collaborative playlist-modify-public playlist-modify-private";
    }

    @RequestMapping("/authorize")
    public ResponseEntity<Object> authorize() {
        URI spotify_auth_uri;

        String spotify_auth_url = "https://accounts.spotify.com/authorize"
                + "?client_id=" + spotify_client_id
                + "&response_type=code"
                + "&redirect_uri=" + redirect_url
                + "&scope=" + scope;

        try {
            spotify_auth_uri = new URI(spotify_auth_url);
        } catch (URISyntaxException e) {
            return new ResponseEntity<>("Invalid Spotify Authorization URL", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
