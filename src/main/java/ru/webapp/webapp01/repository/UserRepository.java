package ru.webapp.webapp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webapp.webapp01.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
}
