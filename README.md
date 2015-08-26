Codes from https://guides.codepath.com/android/Rotten-Tomatoes-Networking-Tutorial

Time: 2 hr

Level: 2/3

Device: Emulator

Testing: Successful with a change

1. Added fit(): Resize poster image. 
Picasso.with(this).load(movie.getLargePosterUrl()).placeholder(R.drawable.large_movie_poster).into(ivPosterImage);
--> Picasso.with(this).load(movie.getLargePosterUrl()).fit().placeholder(R.drawable.large_movie_poster).into(ivPosterImage);

![alt tag](https://cloud.githubusercontent.com/assets/11301947/9485765/489677fe-4b73-11e5-9c82-a5acf8bb8aa0.png)
![alt tag](https://cloud.githubusercontent.com/assets/11301947/9497637/cc37156c-4bca-11e5-85ea-433d00f12891.png)


