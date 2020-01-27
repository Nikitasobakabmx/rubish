package lab5.games.service;

import lab5.games.db.dao.GameRepository;
import lab5.games.db.model.GamesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;


    @Override
    public Iterable<GamesEntity> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void delete(GamesEntity game){
        gameRepository.delete(game);
    }

    @Override
    public void deleteById(String id) {
        gameRepository.delete(Long.parseLong(id));
    }

    @Override
    public GamesEntity findById(String id) {
        return gameRepository.findOne(Long.parseLong(id));
    }

    @Override
    public GamesEntity update(GamesEntity game) {
        GamesEntity tmp = gameRepository.findOne(game.getId());
        tmp = merge(tmp, game);
        gameRepository.save(tmp);
        return tmp;
    }

    private GamesEntity merge(GamesEntity original, GamesEntity badCopy){
        if(original == null)
            throw new NullPointerException("Not found");
        if (badCopy.getCost() != null)
            original.setCost(badCopy.getCost());
        if (badCopy.getName() != null)
            original.setName(badCopy.getName());
        if (badCopy.getStudioName() != null)
            original.setStudioName(badCopy.getStudioName());
        if (badCopy.getDescription() != null)
            original.setDescription(badCopy.getDescription());
        if (badCopy.getPhoto() != null)
            original.setPhoto(badCopy.getPhoto());
        return original;
    }
    @Override
    public void append(GamesEntity game) {
        gameRepository.save(game);
    }
}
