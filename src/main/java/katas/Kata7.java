package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.lang.annotation.ElementType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> movies =movieLists.stream()
                .flatMap(movie-> movie.getVideos().stream()
                        .map(element-> Map.of(
                                "movieId: ",element.getId(),
                                "title: ", element.getTitle(),
                                "boxart: ",element.getBoxarts()
                                .stream().reduce((box1,box2) ->
                                                box1.getWidth() * box1.getHeight() <
                                                        box2.getWidth() * box2.getHeight() ? box1:box2).stream()
                                .map(url-> url.getUrl()).collect(Collectors.toList())))).collect(Collectors.toList());
        System.out.println(movies);
        return movies;
    }
}
