package Services;

import Models.Movie;

public interface MovieService {

    Movie getMovieById(String movieId);

    Movie createMovie(String name);
}
