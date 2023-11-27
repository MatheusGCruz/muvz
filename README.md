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


Proposed data organization:

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


Final data organization
<br/>Endpoints:
<br/>* Object: Anime
<br/>Json:
<br/>{
<br/>	(Integer) animeId, // Auto generated at insertion
<br/>	(String) originalName,
<br/>	(String) englishName,
<br/>	(String) imageUrl,
<br/>	(Integer) releaseYear,
<br/>	(DateTime) registeredAt // Auto generated at insertion
<br/>}
<br/>
<br/>Endpoints:
<br/>
<br/>/animes/all - Get a list of all animes
<br/>/animes/addNew - Add a new anime
<br/>
<br/>* Object: User
<br/>Json:
<br/>{
<br/>	(Integer) userId, 			// Auto generated at insertion
<br/>	(String) nickName,			// Verified to avoid duplication
<br/>	(String) userName,
<br/>	(DateTime) registeredAt 	// Auto generated at insertion
<br/>}
<br/>
<br/>Endpoints:
<br/>/users/all - Get a list of all users
<br/>/users/addNew - Add a new user
<br/>
<br/>* Object: Season
<br/>Json:
<br/>{	
<br/>	(Integer) seasonId, 		// Auto generated at insertion
<br/>	(Integer) animeId,			// Verified to avoid inserting a item without a correspondent
<br/>	(Integer) seasonNumber,
<br/>	(String) seasonName,
<br/>	(DateTime) releaseDate,
<br/>	(Integer) numberOfEpisodes,
<br/>	(Integer) dayOfTheWeek,
<br/>	(Integer) seasonStatus,
<br/>	(DateTime) registeredAt 	// Auto generated at insertion
<br/>}
<br/>
<br/>Endpoints:
<br/>/seasons/all - Get a list of all seasons
<br/>/seasons/addNew - Add a new season item
<br/>/seasons/anime/{id} - Get a lista of seasons by a specific anime ID
<br/>
<br/>* Object: Episode
<br/>Json:
<br/>{
<br/>	(Integer) episodeId, 		// Auto generated at insertion
<br/>	(Integer) animeId,			// Verified to avoid inserting a item without a correspondent 
<br/>	(Integer) seasonId,			// Verified to avoid inserting a item without a correspondent 
<br/>	(Integer) userId,			// Verified to avoid inserting a item without a correspondent 
<br/>	(Integer) episodeNumber,
<br/>	(Integer) episodeStatus,
<br/>	(Integer) episodeScore,
<br/>	(DateTime) registeredAt 	// Auto generated at insertion
<br/>}
<br/>
<br/>Endpoints:
<br/>/episodes/all - Get a list of all watched episodes, by all users and animes
<br/>/episodes/addNew - Add a new episode item
<br/>/episodes/latest/{anime} - Get the last resgister of an episode watched, where the anime original name or english name contains the {anime} value
<br/>/episodes/latest/{nickName}/{anime} - Get the last resgister of an episode watched, where the anime original name or english name contains the {anime} value, and the user registered matches exactly with the {nickName} provided
<br/>/episodes/first/{nickName}/{anime} - Get the first episode watched, where the anime original name or english name contains the {anime} value, and the user registered matches exactly with the {nickName} provided
<br/>/episodes/all/{anime} - Get a list of all watched episodes, where the anime original name or english name contains the {anime} value
