package lab.games.db.dao;


import lab.games.db.model.GamesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<GamesEntity, Long> {
}
