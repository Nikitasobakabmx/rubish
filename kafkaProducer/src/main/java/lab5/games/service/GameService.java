package lab5.games.service;

import lab5.games.db.model.GamesEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public interface GameService {
    Iterable<GamesEntity> findAll();
    void delete(GamesEntity game);
    void deleteById(String id);
    GamesEntity findById(String id);
    GamesEntity update(GamesEntity game);
    void append(GamesEntity game);

}
