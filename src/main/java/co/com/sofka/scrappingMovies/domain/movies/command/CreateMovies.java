package co.com.sofka.scrappingMovies.domain.movies.command;

import co.com.sofka.scrappingMovies.domain.generic.Command;

public class CreateMovies extends Command {

    private  String moviesId;
    private  String name;

    public String getMoviesId() {
        return moviesId;
    }

    public String getName() {
        return name;
    }

    public void setMoviesId(String moviesId) {
        this.moviesId = moviesId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
