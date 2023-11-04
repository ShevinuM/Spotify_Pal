This project is currently being migrated to using JavaScript, ReactJS, NodeJS, ExpressJS, MongoDB. The below are the links to the ongoing development of client and server.
[Client](https://github.com/ShevinuM/SpotifyPal-Client),
[Server](https://github.com/ShevinuM/SpotifyPal-Server)

-----------------------------------------------------------------------

# SpotifyPal

Welcome to SpotifyPal - a custom application designed to enhance your Spotify experience with a suite of new functionalities.

Here is a high level overview of what I have implemented so far. There's a lot more coming.

![Architecture Diagram](UML/Architecture%20Diagram/Architecture_Diagram.drawio.svg)


## Why SpotifyPal?

While Spotify provides a wide array of features, there are specific features that it doesn't natively support through its API. SpotifyPal is designed to bridge this gap by adding custom features that enhance your Spotify experience.

Read more about the motivation behind SpotifyPal in the [project proposal](https://github.com/ShevinuM/SpotifyPal/blob/main/UML/Project%20Proposal/Project-Proposal.md).

## How Does SpotifyPal Work?

The backend service is implemented as a RESTful API, comprised of 9 distinct endpoints, each responsible for specific functionalities. The technology stack is Java-centric, using Spring Boot as the primary framework for developing the server-side logic.

### Technologies and Frameworks

- **Spring Boot**: Backend Framework
- **PostgreSQL**: Relational Database Management System
- **Docker**: Containerization of the PostgreSQL database
- **Spotify OAuth 2.0**: User Authentication
- **Spring Data JPA**: Object-Relational Mapping (ORM)

#### User Authentication

- Integrated Spotify OAuth 2.0 for secure user authentication. Utilized the `OAuth2AuthorizedClient` class to manage and retrieve the authentication tokens.

#### Database Management

- Utilized a Docker container to host the PostgreSQL database for seamless and platform-independent database management.
- Used Spring Data JPA for CRUD operations, entity-to-table mapping, and database transactions. Defined repositories extending the `JpaRepository` interface for object-relational mapping.

### API Endpoint Operations

- The RESTful API is designed with 9 endpoints, performing unique operations mentioned in the expected feature below.

### Testing

- **JUnit5**: Unit Testing Framework
- **AssertJ**: Fluent Assertion Library for enhanced test validation
- **Mockito**: Mocking framework for mocking external API and database calls

#### Mocking and Test Coverage

- Employed Mockito to mock database interactions and Spotify API calls to isolate units of work and perform robust testing.
- Utilized JUnit5 along with AssertJ for creating test cases that cover various edge-cases and scenarios, ensuring high test coverage.


## Features

SpotifyPal is a feature-rich application designed to enhance your music listening experience and bring an analytic approach to playlist management. Here are some of the most exciting features we are working on:

### Intelligent Playlist Sorting Algorithms 🎵
- Utilizes advanced Audio Analysis features such as tempo, key, and mode (Camelot wheel) provided by Spotify Web API to algorithmically sort playlists for optimal song-to-song transitions. 

### Filtered Playlists ⚙️
- Intelligently curate and filtre playlists based on your 'liked' songs, allowing for a more personalized listening experience with only songs you known and love.

### Automated Monthly and Yearly Playlists 🗓️
- Leverages automation to compile monthly and yearly playlists of all songs saved/liked throughout respective time frames. Say goodbye to manual curation!

### Artist-Specific Playlists 🎤
- Easily filter your entire Spotify library to find songs from your favorite artists that you've saved and compile them into specialized playlists.

### Mood-Based Playlist Generation 🌈
- Applies sentiment analysis to create playlists based on your chosen mood and adjusts for the time of day, ensuring a tailor-fit listening experience.

### Top Favorites Playlist 🌟
- Leverages Spotify's streaming history to generate a playlist consisting of your top 'n' tracks of the week, with 'n' being a user-definable value.

### In-Depth Profile Stats 📊
- Utilizes Data Visualization techniques to provide a comprehensive monthly summary of your Spotify profile stats, allowing you to track your listening habits like never before.

**Project Status**: _In Development_  
Stay tuned for more exciting updates as SpotifyPal continues to evolve!

## How To Navigate The Codebase
- [Project Planning with UML](UML)
- [Backend of the Application](spotifypal/src/main/java/com/shevinum)
    - [API Layer](spotifypal/src/main/java/com/shevinum/api)
    - [Configuration Layer](spotifypal/src/main/java/com/shevinum/config)
    - [Data Access Object Layer](spotifypal/src/main/java/com/shevinum/dao)
    - [Model Layer](spotifypal/src/main/java/com/shevinum/model)
    - [Service Layer](spotifypal/src/main/java/com/shevinum/service)
- [Test Classes](spotifypal/src/test/java/com/shevinum)
    - [DAO Tests](spotifypal/src/test/java/com/shevinum/dao)
    - [Model Tests](spotifypal/src/test/java/com/shevinum/model)
    - [Service Tests](spotifypal/src/test/java/com/shevinum/service)


## Software Engineering Principles and Methodologies Employed

SpotifyPal is developed with a strong emphasis on rigorous software engineering principles, employing a blend of proven methodologies and cutting-edge approaches. Below are the specifics:

### Project Planning with UML (Unified Modeling Language) 📈
- Leveraging UML to perform exhaustive systems analysis and design, aiming for a robust, maintainable codebase.
  - **Use Case Diagrams & Descriptions**: To identify system functionalities and interactions.
  - **Activity Diagrams**: For outlining dynamic aspects and workflow within the system.
  - **Layer Diagrams**: To ensure separation of concerns and to define boundaries.
  - **Sequence Diagrams**: For detailing object interactions in specific use-cases.
  - **Class Diagrams**: To model the static structure, showing classes, attributes, operations, and relationships.

### Iterative and Incremental Development 🔄
- Adopting an iterative approach with incremental builds, facilitating rapid prototyping and continuous feedback.
- Usage of Version Control (Git) for tracking changes and facilitating rollbacks.

### Architecture Patterns: N-Tier 🏛️
- Employing an N-Tier architectural pattern to decouple the application into Presentation, Business Logic, and Data Access Layers, thus enhancing maintainability and scalability.

### Design Patterns: MVC (Model-View-Controller) 🎛️
- Implementing the MVC design pattern to segregate application concerns.
  - **Model**: For data manipulation and business logic.
  - **View**: Responsible for UI and presentation logic.
  - **Controller**: Orchestrating the interaction between Model and View.

By adhering to these principles and methodologies, SpotifyPal aims to be not just a functional and user-friendly application, but also a robust, maintainable, and scalable software solution.

 
