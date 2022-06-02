package ch.axa.Datenpersistenz.service;

import ch.axa.Datenpersistenz.model.Joke;
import ch.axa.Datenpersistenz.repository.JokeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JokeService {

    private final JokeRepository repository;

    public Optional<Joke> findJokeByRating(int rating) {
        return repository.findJokeByRating(rating);
    }

    public Iterable<Joke> getJokes() {
        return repository.findAll();
    }

}
