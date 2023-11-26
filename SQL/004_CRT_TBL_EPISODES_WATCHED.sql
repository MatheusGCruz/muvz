DROP TABLE IF EXISTS EPISODES_WATCHED

CREATE TABLE EPISODES_WATCHED
(
    episodes_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    anime_id INT, 
    season_id INT, 
    user_id INT,
    episode_status INT,
    episode_score INT,
    registered_at DATETIME
)