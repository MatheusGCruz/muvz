DROP TABLE IF EXISTS SEASONS

CREATE TABLE SEASONS
(
    season_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    anime_id INT, 
    release_date DATETIME,
    number_episodes INT, 
    season_status INT, 
    registered_at DATETIME
)