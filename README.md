# SpotifyPal

This project is still in its initial stages. Right now I'm working on implementing the configuration for the application including configuring a database inside a docker container. I'm also working on implementing OAuth 2.0.

## Why I'm making this
- Spotify does not natively support all of the scripts that can be executed via its API.
- This application allows me to create custom scripts that can be executed, making my Spotify experience more convenient.
- To address the problem, I am developing a custom application that will provide me with the necessary functionality to perform the required tasks. The application will be specifically designed to meet my needs and ensure that I can complete these tasks efficiently and effectively.
- More about why I'm making this can be read in the [project proposal('https://github.com/ShevinuM/SpotifyPal/blob/main/UML/Project%20Proposal/Project-Proposal.md). 

## How I'm making this
- The SpotifyPal application will use Spring Boot and OAuth 2.0 for authentication, PostgreSQL for the database, and Spotify's API to interact with the user's profile. The front-end is expected to be built with HTML, CSS, JS. Using ReactJS as the front-end framework is something I’m exploring right now.



## Expected Features
1. Sort the songs in a playlist using Audio Analysis features provided by Spotify Web API such as key & mode (Camelot wheel), tempo, and make the transitions between songs of the playlist seamless as possible.
2. Filtre a playlist provided by the user to only include the songs saved by the user and transfer those songs to a new playlist.
3. Compile a monthly playlist out of all the songs the user has saved/liked during the month.
4. Filtre all the songs of a given artist to only include the songs saved by the user and create a new playlist out of those songs.
5. Compile a yearly playlist out of all the songs the user has saved/liked during the year.
6. User selects a 'mood' and a 'duration', and system creates a playlist based on the mood, duration and time of the day.
7. System creates a playlist consisting of the user's top 'n' favorite/most listened to songs during the week, where 'n' is a value input by the user.
8. System displays the user a summary of their profile stats for the month.
 
