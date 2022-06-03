package ch.axa.university.service;

import ch.axa.university.model.Joke;
import ch.axa.university.repository.JokeRepository;
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
