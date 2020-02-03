package lab.games.rest;

import lab.games.db.model.GamesEntity;
import lab.games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/rest/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> get(@RequestParam(value = "id", defaultValue = "null") String id){
        if(!id.equals("null"))
            return ResponseEntity.ok(gameService.findById(id));
        return ResponseEntity.ok(gameService.findAll());
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@RequestParam(value = "id") String id){
        System.out.println("Delete " + id);
        GamesEntity tmp = gameService.findById(id);
        gameService.deleteById(id);
        return ResponseEntity.ok(tmp);
    }

    @RequestMapping(method=RequestMethod.POST, consumes = "application/json", produces = { "application/json", "application/xml" })
    public @ResponseBody ResponseEntity<Object> append(@RequestBody GamesEntity entity){
        System.out.println(entity.getName());
        gameService.append(entity);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody ResponseEntity<Object> update(@RequestBody GamesEntity entity){
        System.out.println(entity.getCost());
        System.out.println(entity.getId());
        GamesEntity tmp = gameService.update(entity);
        return ResponseEntity.ok(tmp);
    }

}
