# MoviesAndRatings

Raw SQL Queries>>>>>>>>>>>>>

to fetch greatest 10 runtime movies:>>>> SELECT * FROM movies ORDER BY runtime_minutes DESC limit 10;

to fetch rating more than 6.0:>>>>> SELECT * FROM ratings where avg_rating > 6.0;

to fetch following details from bith tables:>>>>> SELECT a.tconst, a.primary_title , a.geners, b.avg_rating from movies a inner join ratings b on a.tconst = b.tconst where b.avg_rating > 6.0
