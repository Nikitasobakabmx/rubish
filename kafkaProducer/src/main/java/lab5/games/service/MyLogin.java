package lab5.games.service;

import lab5.games.db.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class MyLogin extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;

    private User user;

    public MyLogin(User user) {
        super(user.getLogin(), user.getHash(), AuthorityUtils.createAuthorityList("ALL"));
        this.user = user;
    }

}
