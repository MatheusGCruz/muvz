# muvz

Project - Design a system 

Propose idea:

Create a Anime follow-up repository

A system that stores animes data (name, image url) to make an follow-up possible.
This system need to have:
-   A way to store diferent users
-   A way to store diferent animes
-   A way to store diferent seasons of an anime
-   A way to a user mark an episode as fully or partialy watched

Origin of this project

As an avid anime watcher, is hard to know what animes I already watched, and wich one is in my queue list.
In a stream service, is possible to know wich anime and episode I already watch, but this also means that, if anyone watches in the same stream, on the same account, the followup wil be lost.


Future developments (it will become a personal project later)
-   Generates a simple follow-up website
-   Generate a simple mobile application
-   Open up the scope to films, series and books also


Data organization

Object: Anime
-   Anime ID
-   Anime original name (romanji)
-   Anime english name
-   Anime image url
-   Anime release year
-   Register created at 

Object: User
-   User ID
-   User NickName
-   User Name
-   Register created at 


Object: Anime season
-   Season ID
-   Anime ID (foreign key)
- 	Season Number
-	Season Name
-   Release Date
-   Number of episodes
-	Day of The Week (1 - Sunday, 7 - Saturday)
-   Status (TBA, displaying, Halted, Canceled)
-   Register created at 


Object: Episode Watched
-   Episode ID
-   Anime ID (foreing key)
-   User ID (foreing key)
-   Status (fully or partially watched)
-   Episode Score 
-   TimeStamp (watched on)


Infrastructure:
-   Backend language: Java 17/Springboot 3.2
-   Database: MS SQL, azure hosted

Endpoints:
Object: Anime

Object: User

Object: Season

Object: Episode


