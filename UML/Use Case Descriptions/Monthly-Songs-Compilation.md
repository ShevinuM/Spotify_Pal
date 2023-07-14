# Monthly Songs Compilation

Status: Done
Project: SpotifyPal (https://www.notion.so/SpotifyPal-1593701e485843b5a7c4434a2955c355?pvs=21)
Parent-task: Write the Use Case Descriptions (https://www.notion.so/Write-the-Use-Case-Descriptions-1efab88d455a48e9ba07107d436837f1?pvs=21)
ID: SSP-50

### **Use Case Title**:

Create Monthly Songs Playlist

### **Primary Actor**:

System

### **Secondary Actor(s)**:

User who is using the application

### **Preconditions**:

User must be logged into the Spotify account and should have given permissions to the system to make modifications to user’s account.

The authorization code must be obtained.

### **Postconditions**:

User should have a new playlist created under the user’s account which includes the name of the month and all the songs user has liked during the month added to it.

### **Main Success Scenario (Basic Flow)**:

1. User proceed to generate the monthly playlist.
2. System gets the id of the current user.
3. System gets the first 50 user’s saved tracks.
4. System retrieves the added_at date from each track.
5. System converts each added_at date to a Time object.
6. System compares the timestamp to check if it’s equal to the current month.
7. If so, system stores the “uri” for the track in a separate data structure.
8. System checks if there are more tracks remaining in the user’s saved library.
9. If not, System gets the first 50 playlists owned by the user.
    
    Alt2: There are more tracks remaining
    
10. System checks if each playlist has a,
    1. name equal to the name of the month.
    2. id of owner of the playlist is equal to the current user id.
11. if so, System stores the songs in the data structure into that playlist
    
    Alt3: There is no playlist matching the above conditions.
    

### **Alternative Flows**

********Alt2********

1. System gets the next 50 user’s saved tracks.
2. Flow continues from step 4 of the Main Success Scenario

********Alt3********

1. System creates a new playlist in the user’s profile with the name equal to the current month.
2. System stores the songs in the data structure to that playlist.