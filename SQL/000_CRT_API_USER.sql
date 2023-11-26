CREATE LOGIN api_user   
    WITH PASSWORD = 'Muvz@2023';  
GO  

CREATE USER api_user 
    FOR LOGIN api_user
	WITH DEFAULT_SCHEMA = dbo

GO  


EXEC sp_addrolemember N'db_owner', N'api_user'
GO
