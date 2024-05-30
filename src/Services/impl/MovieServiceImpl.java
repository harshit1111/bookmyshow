package Services.impl;

import Models.Movie;
import Services.MovieService;

import java.util.HashMap;
import java.util.Map;

public class MovieServiceImpl implements MovieService {

    Map<String,Movie> movieMap;

    public  MovieServiceImpl(){
        movieMap = new HashMap<>();
    }
    @Override
    public Movie getMovieById(String movieId) {
        return movieMap.get(movieId);
    }

    @Override
    public Movie createMovie(String name) {
        Movie movie = new Movie(name);
        movieMap.put(movie.id , movie);
        return movie;
    }
}
