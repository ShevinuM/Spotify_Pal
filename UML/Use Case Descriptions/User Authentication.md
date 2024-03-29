# User Authentication

Status: Done
Project: SpotifyPal (https://www.notion.so/SpotifyPal-1593701e485843b5a7c4434a2955c355?pvs=21)
Parent-task: Write the Use Case Descriptions (https://www.notion.so/Write-the-Use-Case-Descriptions-1efab88d455a48e9ba07107d436837f1?pvs=21)
Priority: High
ID: SSP-48

### Use Case Title

Spotify User Authentication

### Primary Actor

System

### Secondary Actor(s):

User using the application

### Preconditions

1. User has a valid Spotify account.
2. The system is registered as a Spotify Developer Application and has the required Client ID and Client Secret.
3. The system has the required redirect URI set up in the Spotify Developer Dashboard.

### Postconditions

1. System has obtained the necessary access token to read and modify the user’s Spotify profile.
2. User’s Spotify profile can be accessed and modified within the scope of permissions granted.

### Main Success Scenario

1. User initiates the Spotify authentication process.
2. System redirects the user to the Spotify Accounts authorization page, with the necessary query parameters, including the required scopes for reading and modifying the user’s profile.
3. User logs into their Spotify profile.
4. User reviews the permissions requested by the system and confirms by clicking ‘Agree’.
    
    Alt1 : User denies the permission request
    
5. Spotify redirects the user back to the system using the specified redirect URI, providing an authorization code in the query parameters of the redirect URI.
6. System extracts the authorization code from the redirect URI.
7. System makes a POST request to the Spotify Accounts api/token endpoint, providing the authorization code, redirect URI, Client ID, and Client Secret.
8. Spotify responds with an access token and a refresh token.
9. System stores the access token and refresh token securely for later use.

### Alternative Flows

********Alt1********

1. System notifies the user that the application won’t be able to proceed without these permissions. 

********Alt2********

1. Is the access token expires, the System uses the refresh token to get a new access token by making a POST request to the Spotify Accounts ‘api/token’ endpoint, providing the refresh token ,Client ID, and Client Secret.