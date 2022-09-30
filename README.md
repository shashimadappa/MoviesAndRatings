# MoviesAndRatings

hello, I have weitten code to upload csv files into the data base via Springboot and wrote extra apis as well to fetch all the data...

Raw SQL Queries>>>>>>>>>>>>>

to fetch greatest 10 runtime movies:>>>> SELECT * FROM movies ORDER BY runtime_minutes DESC limit 10;

to fetch rating more than 6.0:>>>>> SELECT * FROM ratings where avg_rating > 6.0;

to fetch following details from bith tables:>>>>> SELECT a.tconst, a.primary_title , a.geners, b.avg_rating from movies a inner join ratings b on a.tconst = b.tconst where b.avg_rating > 6.0

THANK YOU...


apis videos>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.

https://user-images.githubusercontent.com/103553061/193222689-6c3938ac-10e3-444f-99ec-1b9c7a901dcd.mp4



https://user-images.githubusercontent.com/103553061/193222758-f089560b-2aee-4034-8141-b91ed970e9fa.mp4

