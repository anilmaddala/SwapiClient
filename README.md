# Star Wars API Client  
  
This is a Android client implementation of [Star Wars API](https://swapi.dev/).

The project uses **Clean Architecture** and **MVVM**. 
Following features of JetPack and Kotlin are used:
 - Hilt
 - Data Binding
 - Navigation
 - LiveData
 - Coroutines
 - Flow

You can search for your favorite Star Wars character and navigate to the films they appeared in. You can continue navigating from the film to any of the characters who were part of that film. The back navigation stack is maintained and data persists (Thanks to LiveData and ViewModel!)

The images are queried from [https://starwars-visualguide.com/](https://starwars-visualguide.com/)
Following libraries are used uned the hood:

 - Retrofit for Networking
 - Glide for loading images
 - 

**TODO**

 - Implement Paging 3 Library for smoother page loads. The current implementation only loads one page at a time.
 - Implement Room persistance for local caching.
 - Implement NetworkBoundResource to achieve single source of truth.
 - Implement listing and detail pages for Planets, Species, Starships, Vehicles. The current architecture supports to easily implement the remaining pages.
 - Implement Test cases

***MAY THE FORCE BE WITH YOU!***

