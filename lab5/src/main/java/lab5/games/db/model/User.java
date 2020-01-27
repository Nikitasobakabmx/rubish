package lab5.games.db.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "login", nullable = false)
    private String login;

    @Basic
    @Column(name = "hash", nullable = false)
    private String hash;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash()
    {
        System.out.println(hash);
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
