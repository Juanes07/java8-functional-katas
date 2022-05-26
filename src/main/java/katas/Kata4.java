package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Map> newList = movieLists.stream().flatMap((movies) -> movies.getVideos().stream())
                .map(video ->
                        Map.of("id ", video.getId(),
                                "title ", video.getTitle(),
                                "boxArt ", video.getBoxarts().stream()
                                        .filter(ele -> ele.getWidth() == 150 && ele.getHeight() == 200)
                                        .map(url -> url.getUrl()).collect(Collectors.toList()))).collect(Collectors.toList());
        ;
        System.out.println(newList);
        return newList;
    }
}
