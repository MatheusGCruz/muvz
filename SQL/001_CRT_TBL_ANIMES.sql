DROP TABLE IF EXISTS ANIMES

CREATE TABLE ANIMES
(
    anime_id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    original_name NVARCHAR(255),
    english_name NVARCHAR(255),
    image_url NVARCHAR(255),
    release_year int,
    registered_at DATETIME
)