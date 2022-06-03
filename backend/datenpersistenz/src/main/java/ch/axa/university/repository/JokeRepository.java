package ch.axa.university.repository;

import ch.axa.university.model.Joke;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface JokeRepository extends CrudRepository<Joke, Integer> {

    public Optional<Joke> findJokeByRating(int rating);
}
