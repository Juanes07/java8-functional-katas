package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        String urlLargest = movies.stream().flatMap(element -> element.getBoxarts().stream())
                .reduce((box1, box2) ->
                        box1.getWidth() * box1.getHeight()
                                > box2.getWidth() * box2.getHeight() ? box1 : box2)
                .map(element -> element.getUrl()).get().toString();
        System.out.println("URL de la caratula mas grande: " + urlLargest);
        return urlLargest;
    }
}
