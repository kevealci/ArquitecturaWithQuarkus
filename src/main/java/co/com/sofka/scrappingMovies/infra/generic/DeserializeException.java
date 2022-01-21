package co.com.sofka.scrappingMovies.infra.generic;

public class DeserializeException extends RuntimeException {
    public DeserializeException(Throwable cause) {
        super(cause);
    }
}