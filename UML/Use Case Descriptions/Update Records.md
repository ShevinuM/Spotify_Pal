# Update Records

Status: Done
Project: SpotifyPal (https://www.notion.so/SpotifyPal-1593701e485843b5a7c4434a2955c355?pvs=21)
Parent-task: Write the Use Case Descriptions (https://www.notion.so/Write-the-Use-Case-Descriptions-1efab88d455a48e9ba07107d436837f1?pvs=21)
Priority: High
ID: SSP-57

### Use Case Title

Update Records

### Primary Actor

System

### Secondary Actors

User who is using the application

### Pre-Conditions

- User must be logged into the Spotify account and should have given permissions to the system to read/modify the user's Spotify profile.
- The database is initialized, and the connection with the application is established.
- The application has obtained a valid access token from Spotify to access the user's data.

### Post-Conditions

- The user's saved songs and their relevant information (name, URI, artist, timestamp the song was added, ID, danceability, duration, energy, key, mode, tempo, valence) are retrieved and stored in one table of the database.
- The user's playlists and their relevant information (name, ID) are retrieved and stored in a separate table in the database.

### Main Success Scenario

1. User selects to update a record
2. System uses Spotify's Web API to fetch the user's saved tracks.
3. System fetches the first 50 tracks.
    
    Alt1 : There are more than 50 tracks which user has saved
    
4. For each track, the System retrieves the relevant song details 
    1. name,
    2. URI,
    3. artist,
    4. timestamp the song was added,
    5. id,
    6. danceability,
    7. duration,
    8. energy,
    9. key,
    10. mode,
    11. tempo,
    12. valence 
    
    and inserts them into a table into the database.
    
5. System uses Spotify's Web API to fetch the user's created playlists.
6. For each playlist, the System retrieves the relevant details
    1. name,
    2. id
    
     and inserts them into a separate table in the database
    

### Alternative Flows

**Alt1**

1. System makes additional API requests to retrieve all songs or playlists.
2. Flow continues from step 4 or 6 of the Main Success Scenario.

**Alt2**

1. If a network error, API error (like invalid token, rate limiting, or Spotify service unavailable) occurs, the system should log the error, provide an appropriate message to the user, and retry the operation if necessary.

**Alt3**

1. If a database error (like connection issues, write errors, or integrity constraint violations) occurs, the system should log the error and potentially alert the user or the system administrator. If possible, the system should try to recover from the error and continue the operation.