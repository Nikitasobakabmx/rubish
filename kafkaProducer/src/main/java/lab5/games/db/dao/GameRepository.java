package lab5.games.db.dao;


import lab5.games.db.model.GamesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<GamesEntity, Long> {
}
