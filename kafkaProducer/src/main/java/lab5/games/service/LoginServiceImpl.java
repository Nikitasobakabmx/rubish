package lab5.games.service;

import lab5.games.db.dao.UserRepository;
import lab5.games.db.model.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        User login = userRepository.findByLogin(string);
        if (login == null) {
            throw new UsernameNotFoundException("user not found");
       }

        return new MyLogin(login);
    }

}
