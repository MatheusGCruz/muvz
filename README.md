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
* Object: Anime
Json:
{
	(Integer) animeId, // Auto generated at insertion
	(String) originalName,
	(String) englishName,
	(String) imageUrl,
	(Integer) releaseYear,
	(DateTime) registeredAt // Auto generated at insertion
}
Endpoints:
/animes/all
- Get a list of all animes

/animes/addNew
- Add a new anime

* Object: User
Json:
{
	(Integer) userId, 			// Auto generated at insertion
	(String) nickName,			// Verified to avoid duplication
	(String) userName,
	(DateTime) registeredAt 	// Auto generated at insertion
}
Endpoints:
/users/all
- Get a list of all users

/users/addNew
- Add a new user

* Object: Season
Json:
{	
	(Integer) seasonId, 		// Auto generated at insertion
	(Integer) animeId,			// Verified to avoid inserting a item without a correspondent
	(Integer) seasonNumber,
	(String) seasonName,
	(DateTime) releaseDate,
	(Integer) numberOfEpisodes,
	(Integer) dayOfTheWeek,
	(Integer) seasonStatus,
	(DateTime) registeredAt 	// Auto generated at insertion
}
Endpoints:
/seasons/all
- Get a list of all seasons

/seasons/addNew
- Add a new season item

/seasons/anime/{id}
- Get a lista of seasons by a specific anime ID

* Object: Episode
Json:
{
	(Integer) episodeId, 		// Auto generated at insertion
	(Integer) animeId,			// Verified to avoid inserting a item without a correspondent 
	(Integer) seasonId,			// Verified to avoid inserting a item without a correspondent 
	(Integer) userId,			// Verified to avoid inserting a item without a correspondent 
	(Integer) episodeNumber,
	(Integer) episodeStatus,
	(Integer) episodeScore,
	(DateTime) registeredAt 	// Auto generated at insertion
}
Endpoints:
/episodes/all
- Get a list of all watched episodes, by all users and animes

/episodes/addNew
- Add a new episode item

/episodes/latest/{anime}
- Get the last resgister of an episode watched, where the anime original name or english name contains the {anime} value

/episodes/latest/{nickName}/{anime}
- Get the last resgister of an episode watched, where the anime original name or english name contains the {anime} value, and the user registered matches exactly with the {nickName} provided

/episodes/first/{nickName}/{anime}
- Get the first episode watched, where the anime original name or english name contains the {anime} value, and the user registered matches exactly with the {nickName} provided

/episodes/all/{anime}
- Get a list of all watched episodes, where the anime original name or english name contains the {anime} value
