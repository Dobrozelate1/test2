import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class MoviesAnalyzer {

    static class Movie {
        String title;
        String duration;
        List<String> actors;
        List<Integer> watchlist;
        List<Integer> favorites;

        List<Rating> ratings;
    }

    static class Rating {
        int userId;
        int rating;
    }

    static class User {
        int userId;
        String email;
        List<Integer> friends;
    }

    List<Movie> movies;

    List<User> users;

    public MoviesAnalyzer(List<Movie> movies, List<User> users) {
        this.movies = movies;
        this.users = users;
    }

    public List<String> topWatchlistedMoviesAmongFriends(int userId) {
        List<Movie> WachtedMovies = new ArrayList<>();
        TreeMap<Integer, String> FriendsWhatched = new TreeMap<>();
        List<Integer> WhatchedCount = new ArrayList<>();
        List<String> result = new ArrayList<>();
//        Integer count = null;
//        String movie = null;
        List<Integer> counts = new ArrayList<>();
        User watcher = new User();
            List<String> WachtlistMovies = new ArrayList<>();
            List<Integer> watchlist = new ArrayList<>();

      for (User user : users)
        {
            if (user.userId == userId)
                watcher = user;
        }
        List<Integer> UserFriends = watcher.friends;
        for (Movie movie : movies)
        {
            watchlist = movie.watchlist;
            FriendsWhatched.put(getCrossingNumber(watchlist, UserFriends), movie.title);
        }
        FriendsWhatched.forEach((count, movie) -> counts.add(count)) ;
        Collections.sort(counts);
        for(int i = 0; i<4;i++)
        {
            if (FriendsWhatched.get(counts.get(i)) != null)
            result.add(FriendsWhatched.get(counts.get(i)));
        }


        return result;
    }

    private static int getCrossingNumber(List<Integer> listOne, List<Integer> listTwo)
    {
        List<Integer> result = new ArrayList<>();
        for(Integer temp : listOne){
            for(Integer tmp : listTwo){
                if(temp.equals(tmp)){
                    result.add(temp);
                }
            }
        }
        Collections.sort(result);
        return result.size();
    }

}
