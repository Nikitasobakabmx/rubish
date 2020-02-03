package lab.games.service;

import lab.games.db.model.GamesEntity;
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
