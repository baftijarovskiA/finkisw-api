package mk.ukim.finki.seminar.FinkiSW.Auth.repository;

import mk.ukim.finki.seminar.FinkiSW.Auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username=:username")
    User findByUsername(String username);

    @Query("select u from User u where u.email=:email")
    User findUserByEmail (String email);
}
