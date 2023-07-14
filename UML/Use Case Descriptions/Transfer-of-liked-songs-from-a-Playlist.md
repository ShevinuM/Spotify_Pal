# Transfer of Liked Songs from a Playlist

Status: Done
Project: SpotifyPal (https://www.notion.so/SpotifyPal-1593701e485843b5a7c4434a2955c355?pvs=21)
Parent-task: Write the Use Case Descriptions (https://www.notion.so/Write-the-Use-Case-Descriptions-1efab88d455a48e9ba07107d436837f1?pvs=21)
Priority: High
ID: SSP-49

### **Use Case Title**:

Transfer of Liked Songs from a Playlist

### **Primary Actor**:

System

### **Secondary Actor(s)**:

User who is using the application

### **Preconditions**:

User must be logged into the Spotify account and should have given permissions to the system to make modifications to user’s account. 

The authorization code must be obtained.

### **Postconditions**:

User should have a new playlist created under the user’s account which includes all the liked songs of the playlist user provided with a link.

### **Main Success Scenario (Basic Flow)**:

1. User provides a link to the Spotify Playlist.
2. System checks if the link is a valid link to a Spotify playlist.
3. System extracts the playlist_id from the link user provides.
    
    Alt1 : link is invalid
    
4. System gets all the tracks associated with the playlist id.
    
    Alt2 : playlist_id is invalid
    
5. System filters out the tracks which the user has liked.
6. System gets the name of the playlist, playlist_id represent.
7. System creates a new playlist in the user’s account with that name.
8. System adds all the filtered songs to that playlist.

### **Alternative Flows**

**********Alt1:**********

1. System informs the user that the link is invalid.
2. System allows the user to re-enter the link.
3. Flow continues from step 2 in main success scenario.

********Alt2********

1. System informs the user that a playlist of that link doesn’t exist.
2. System allows the user to re-enter the link.
3. Flow continues from step 2 in main success scenario.