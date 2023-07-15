# Create Project Proposal

Status: Done
Project: SpotifyPal (https://www.notion.so/SpotifyPal-1593701e485843b5a7c4434a2955c355?pvs=21)
ID: SSP-7
Is Blocking: Write the Use Cases (https://www.notion.so/Write-the-Use-Cases-c9130c42bd9b49adafe071926385b0f0?pvs=21)

# 👀 Problem

- Spotify does not natively support all of the scripts that can be executed via its API.
- This application allows me to create custom scripts that can be executed, making my Spotify experience more convenient.
- Here are the current problems with the Spotify app:
    1. Playlists on Spotify include a mixture of liked and unliked songs, limiting the use of Spotify's provided playlists to me. I had to manually move all my liked songs to a playlist.
    2. Many people, including myself, like to create a monthly playlist to keep track of songs they liked during the month. To achieve this on Spotify, you have to manually add each song to a playlist every time you listen to it, which is time-consuming.
    3. Spotify provides OnRepeat, but it seems to be very inaccurate in my opinion. I need a favourites playlist that updates songs based on an algorithm I write so I can access my favourites anytime.
    4. I love Spotify's yearly review where it gives me my stats for the year. I would also like it to send me an email at the end of each month containing my Spotify stats for that month.
    5. Spotify provides various playlists based on categories, but I want to fine-tune these to my preferences. I need a playlist creator that provides some categories and allows the user to enter the total time duration and create a playlist containing only their liked songs.

---

# 💭 Proposal

- To address the problem, I am developing a custom application that will provide me with the necessary functionality to perform the required tasks. The application will be specifically designed to meet my needs and ensure that I can complete these tasks efficiently and effectively.
- To achieve this, I will leverage the capabilities of the Spotify Web API, which will allow me to seamlessly integrate the functionality of the music streaming platform with my custom application. By doing so, I will be able to create a powerful tool that will enable me to accomplish these tasks with ease.

---

# 🛫 Plan

- The SpotifyPal application will use Spring Boot and OAuth 2.0 for authentication, PostgreSQL for the database, and Spotify's API to interact with the user's profile. The front-end is expected to be built with HTML, CSS, JS. Using ReactJS as the front-end framework is something I’m exploring right now.