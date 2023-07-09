package ru.webapp.webapp01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.webapp.webapp01.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByRole(String role);

}
