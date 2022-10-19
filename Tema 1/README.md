Object Oriented Programming Course
Homework - VideosDB

November 2020

# Info
https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/tema

# Tema1 POO - VideosDB
# Dumitru Elena Bianca

## Implementare:
- Am facut clase speciale, asemanatoare ca impartire cu cele deja existente in 
schelet: 
	- Astfel, in main avem clase de baza precum: Actions, Movies, Serials,
	Users, Actors care preiau informatiile din database prin intermediul
	claselor Input si InputLoader deja implementate
	- Aceste clase fac impartirea mai departe in clasele care vor imple-
	menta functionalitatile particulare pentru rezolvarea cerintelor, 
	respectiv: "apply*Type"
		- Action: face impartirea in functie de tipul actiunii in cla-
			sele: Command, Query, Recommendation care vor avea cate
			o functie care se ocupa mai departe de gestionarea
			metodelor din celelalte clase in functie de type-ul
			actiunii
		- Movies: initializeaza clasa Movie care contine toate filmele
			din database
		- Serials: initializeaza clasa Serial care contine toate seria-
			lele din database
		- Users: imparte utilizatorii in cele 2 categorii: premium si
			basic; initializeaza clasa User care va implementa
			metodele pentru utilizatori si care va fi extinsa de
			clasele PremiumUser si BasicUser
		- Actors: initializeaza clasa Actor care contine toti actorii 
			din database
- Am facut o clasa speciala numita JSONArray care se ocupa de scrierea mesajelor
in functie de actiune si de tipul acesteia. Aceasta are un camp: lista de 
JSONObjects pe care o vom atasa variabilei arrayResult din main 
- In main, am instantiat clasele de mai sus pentru a le folosi ca parametru
in functiile din clasele de tip actiune. Acestea prelucreaza datele si apoi
se folosesc de clasa JSONArray pentru a dat append unui nou output.
- Iteram prin actiunile din baza de date in ordinea in care acestea apar si, in
functie de caz, apelam metoda din clasa corespunzatoare:
	- Command: 
		- Favorite: apelam metodele:
			- alreadyInFavorites din clasa User care verifica daca
				un video este deja in lista de favorites a user-
				ului respectiv
			- addToFavorites din clasa User care adauga un video cu
 				succes in lista de favorite a unui user
		- View : apelam metoda:
			- addToViewed: din clasa User care adauga in History un
 				video vizualizat de un utilizator sau 
				incrementeaza numarul de vizualizari
		- Rating: apelam metoda:	
			- isInHistory din clasa User care verifica daca un video
				a fost vizualizat sau nu pentru a-i putea da
				rating 
			- rateVideo din clasa User care actualizeaza campurile
				ratedMovies si ratedShows din UserInputData
				(reprezinta un Hashmap de String, Double pentru
				filme respectiv String, Array de Season pentru
 				seriale) si seteaza si numarul de rating-uri
				dat de fiecare utilizator
	- Query: 
		- Actors: 	
			- Average: aplicam metodele:
        - setMovieRatings, respectiv setSerialRatings din clasele Movie si Serial pentru a le folosi mai departe in calculul
      rating-ului pentru fiecare actor
        - setAverageFilmRatings din clasa Actor care calculeaza
      rating-ul fiecarui actor, folosindu-se de datele setate in movie
      si serial
        - getActorsWithNonZeroRatings din clasa Actor care 
      intoarce o lista cu actorii care au rating-ul diferit de zero,
      adica care nu au primit rating
        * sortByRating din clasa Actor care sorteaza actorii in
      functie de rating
			- Awards: aplicam metodele:
        - getActorsWithAwards din clasa Actor care intoarce o
      lista cu actorii care au awards-urile din filters
        - sortByAwards din clasa Actor care sorteaza actorii in 
      functie de numarul de awards
			- Filter Description: aplicam metodele:
        - getActorsWithFilterDescription din clasa Actor care
      intoarce o lista cu actorii a caror descriere contine filtrele
      din query
        - sortAlphabetically din clasa Actor care sorteaza
      actorii alfabetic
		- Movies/Shows: 
			- Ratings: aplicam metodele:
        - getMovies(Serials)WithFilterDescription din clasa
        Movie/Serial care intoare o lista cu filmele/serialele
        care contin descrierea din query
        - eliminateNonRated din clasa Movie/Serial care elimina
        toate filmele/serialele care nu au primit rating
        - sortByRating din clasa Movie/Serial care sorteaza
        video-urile in functie de rating
			- Favorite: aplicam metodele:
        - setMovie(Serial)FavoriteOccurrence din clasa Movie/
        Serial care seteaza numarul de aparitii in listele
        de favorite ale utilizatorilor
        - getMovies(Serial)WithFilterDescription - idem
        - eliminateNonFavorites din clasa Movie/Serial care 
        elimina video-urile care nu apar in nicio lista de
        - sortByFavoriteOccurrence din clasa Movie/Serial 
        care sorteaza video-urile in functie de numarul de 
        aparitii in listele de favorite ale utilizatorilor
        favorite
			- Longest: aplicam metodele:
        - getMoviesWithFilterDescription - idem
        - sortByDuration din clasa Movie/Serial care sorteaza 
        video-urile in functie de durata lor 
			- Most Viewed: aplicam metodele:
        - getMovies(Serials)WithFilterDescription - idem
        - eliminateNonViewed din clasa Movies/Serial care 
        elimina video-urile care nu au fost vizualizate
        - sortByViews din clasa Movie/Serial care sorteaza 
        video-urile in functie de numarul de views
		- Users:
			- Number Ratings
        - eliminateNonRaters din clasa User care elimina toti
        userii care nu au dat niciun rating
        - sortByNoGivenRatings din clasa User care sorteaza
        userii in functie de numarul de rating-uri date
	- Recommendation:
		- Standard: aplicam metoda:
 			- getStandardRecommendation2 din clasa User care 
			intoarce numele recomandarii standard
		- Best Unseen: aplicam metoda:
			- getStandardRecommendation - idem: retine best unseen
			movie si serial, compara rating-urile celor 2 si 
			il intoarce pe cel cu rating mai mare
		- Favorite: aplicam metoda: 
			- setMovieFavoriteOccurrence din clasa Movie/Serial 
			- sortByOrder3 din clasa Movie/Serial care sorteaza
			video-urile in functie de numarul de aparitii in 
			listele de favorite si apoi in functie de ordinea din
			database
			- getStandardRecommendation - idem: retine best unseen
			movie si serial, compara rating-urile celor 2 si 
			il intoarce pe cel cu rating mai mare
		- Popular: aplicam metodele: 
			- setMovie(Serial)Views din clasa Movie/Serial
			- getPopularRecommendation din clasa User care intoarce
			primul video nevazut din cel mai popular gen
		- Search: aplicam metodele:
			- getSearchRecommendation din clasa User care intoarce
			video-ul din genul dat ca parametru cu cel mai bun
			rating
