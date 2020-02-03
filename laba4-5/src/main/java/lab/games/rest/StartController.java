package lab.games.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/")
public class StartController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(){
        ModelAndView mav = new ModelAndView("games");
        //mav.addObject("games",  gameService.findAll());
        return mav;
    }
    private String messagesBasename = "/classes/games";
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setFallbackToSystemLocale(false);
//        messageSource.setBasenames("file:" + messagesBasename);
        messageSource.setBasename("classpath:games");
        return messageSource;
    }
}



