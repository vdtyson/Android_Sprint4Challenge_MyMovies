# Android_Sprint4Challenge_MyMovies

### Instructions

**Please read this entire README to make sure you understand what is expected of you before you begin.**

This sprint challenge is designed to ensure that you are competent with the concepts taught throughout the Sprint covering Data Persistence.

In your solution, it is especially important that you follow best practices such as MVC and good, consistent code style. You will be scored on these aspects as well as the project MVP (minimum viable product) requirements below.

Fork this repository and clone your fork to your computer. Create your Android Studio project in this cloned fork repository folder, then commit and create a pull request. Commit appropriately as you work. When finished, push your final project to GitHub and comment on the pull requestto indicate that your project is complete.

You have *3 hours*, and you should work *independently* — looking things up (search, notes) is all fair game. And questions about *process* / *logistics* (i.e. if you have a hard time opening/saving to GitHub) are fair game too.

Good luck!

### Screen Recording

This screen recording previews the look and feel of a completed project that meets the MVP requirements for this project.

<img src="./myMoviesDemo_shorter.webm" width="300">

## Requirements

This project uses The Movie DB API. The API documentation is at [https://developers.themoviedb.org/3/getting-started/introduction], but much of what you will need is included below.

The requirements for this project are as follows:

1. A `FavoriteMovie` class. Its members will be used to store favorite movies in your Room database and allow users to add movies to their favorites and mark them as watched.

   > This will be your only local storage of movies, so you'll want to include anything you wish to  display to the user like the title

2. A `MoviesAPI` Retrofit class that implements a call to the "search/movie" endpoint (see [https://developers.themoviedb.org/3/search/search-movies]).

3. A Room database that can perform CRUD operations with a `FavoriteMovie` entity.

4. A `MainActivity` that allows a user to:

   1. Enter a search parameter and pass it to the `MovieAPI` "search/movie" endpoint and view a list of results.

   2. Select movies for favorites (store these in Room DB)

   3. Navigate to the favorites page

5. A `FavoritesActivity` that allows a user to:

   1. View a list of saved movies from the Room DB

   2. Mark individual movies as watched or not

   3. Remove movies from the favorites list

6. All of the background classes we've worked with this week to facilitate database interactions. 

#### Hints
1. The API requires a key. There is a key provided in the `MovieConstants` file under the val `API_KEY_PARAM`. If you want your own key, you can register for an account at [https://www.themoviedb.org/account/signup] and request a key at [https://www.themoviedb.org/settings/api] (recommended if you want to use the API outside of this project).

2. Store the API key in SharedPreferences and retreive it to pass as a query parameter when making the API call.

3. A call to the search/movie endpoint looks like this (for a search on "Avengers" with an API key of "12345"): `https://api.themoviedb.org/3/search/movie?language=en-US&page=1&include_adult=false&query=Avengers&api_key=12345`

      > The base url is `https://api.themoviedb.org/3`

      > There are several *query parameters* that do not change. They can be included as part of the endpoint in your request. For example, the endpoint might be `/search/movie?language=en-US&page=1&include_adult=false`

      > You'll have to include query parameters in your function call, each parameter annotated with @Query, to pass in the api key and the search parameter. For example, the Retrofit interface declaration for a call to an endpoint `/friends` with query parameter `page` could be written like this:

```
@GET("/friends")
fun friends(@Query("page") page: Int): Call<FriendResponse>
```

4. Request results are returned in a JSON object, stored as a JSONArray in the `results` attribute of the object. You have been provided with a `MovieSearchResult` and a `MovieOverview` object that GSON will use to parse the result object. In your Retrofit `Callback` `onResponse`, the response body will contain a single `MovieSearchResult`, and the list of movies will be in the results member variable (in code, something like `response.body.results`).

##Challenge
1. Try using a `ViewModel` and `LiveData` to handle configuration changes and automatic updates.