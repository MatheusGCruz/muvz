DROP TABLE IF EXISTS COMP_STATUS

CREATE TABLE COMP_STATUS
(
    comp_status_id  INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
    status_desc     NVARCHAR(50),
    status_type     NVARCHAR(50),
    registered_at   DATETIME
)
