package lab5.games.db.dao;

import lab5.games.db.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Integer> {

    User findByLogin(String login);

}
