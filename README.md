# SpotifyPal

Welcome to SpotifyPal - a custom application designed to enhance your Spotify experience with a suite of new functionalities.

## Why SpotifyPal?

While Spotify provides a wide array of features, there are specific tasks that it doesn't natively support through its API. SpotifyPal is designed to bridge this gap by allowing you to execute custom scripts and control your music experience more conveniently and effectively. 

Read more about the motivation behind SpotifyPal in the [project proposal](https://github.com/ShevinuM/SpotifyPal/blob/main/UML/Project%20Proposal/Project-Proposal.md).

## How Does SpotifyPal Work?

SpotifyPal is built using Spring Boot and utilizes OAuth 2.0 for authentication. It uses a PostgreSQL database and the Spotify API to interact with your Spotify profile. The front-end is built using HTML, CSS, and JavaScript, and I'm currently exploring the possibility of using ReactJS as the front-end framework.

## Features

SpotifyPal aims to introduce the following features:

1. **Playlist Sorting:** Sort the songs in your playlist using Audio Analysis features (e.g., key & mode - Camelot wheel, tempo) provided by the Spotify Web API to ensure smooth transitions between songs.
2. **Filtered Playlists:** Filter any given playlist to only include songs you've saved and transfer them to a new playlist.
3. **Monthly Playlists:** Compile a monthly playlist of all the songs you've saved/liked throughout the month.
4. **Artist-specific Playlists:** Filter all songs from a given artist to only include the ones you've saved and create a new playlist out of them.
5. **Yearly Playlists:** Compile a yearly playlist of all the songs you've saved/liked throughout the year.
6. **Mood-based Playlists:** Create playlists based on your selected 'mood' and 'duration', adjusting for the time of day.
7. **Top Favorites Playlist:** Generate a playlist consisting of your top 'n' favorite/most listened to songs during the week, where 'n' is a value input by you.
8. **Profile Stats:** Display a summary of your Spotify profile stats for the month.

The project is currently in its initial stages, focusing on application configuration, including setting up a PostgreSQL database inside a Docker container, and implementing OAuth 2.0 authentication.

Watch this space for more updates as SpotifyPal develops!

## Software Engineering Principles Used
1. **Project Planning with UML:** Although UML is not used for many personal projects, I'm using it for mine since it has helped me a lot in the past to visualize things, avoid errors and make the codebase more organized. I'm incorporating the following UML Diagrams into my project,
 - Use Cases & Use Case Descriptions
 - Activity Diagrams
 - Layer Diagrams
 - Sequence Diagrams
 - Class Diagrams
2. **Iterative and Incremental Development**
3. **Architecture Patterns:** N-Tier
4. **Design Patterns:** MVC - Model-View-Controller
 
