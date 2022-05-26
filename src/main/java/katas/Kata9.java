package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> movies = movieLists.stream().flatMap(element -> element.getVideos().stream())
                .map(movie -> Map.of(
                        "movieId: ", movie.getId(),
                        "title: ", movie.getTitle(),
                        "moment: ", movie.getInterestingMoments().stream().map(timeInteresting -> timeInteresting.getTime()).collect(Collectors.toList()),
                        "url", movie.getBoxarts().stream().filter(size -> size.getWidth() <= 150)
                                .map(url -> url.getUrl()).collect(Collectors.toList()))).collect(Collectors.toList());
        System.out.println(movies);
        return movies;
    }
}
