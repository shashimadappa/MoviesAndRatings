# MoviesAndRatings

hello, I have weitten code to upload csv files into the data base via Springboot and wrote extra apis as well to fetch all the data...

Raw SQL Queries>>>>>>>>>>>>>

to fetch greatest 10 runtime movies:>>>> SELECT * FROM movies ORDER BY runtime_minutes DESC limit 10;

to fetch rating more than 6.0:>>>>> SELECT * FROM ratings where avg_rating > 6.0;

to fetch following details from bith tables:>>>>> SELECT a.tconst, a.primary_title , a.geners, b.avg_rating from movies a inner join ratings b on a.tconst = b.tconst where b.avg_rating > 6.0

THANK YOU...
