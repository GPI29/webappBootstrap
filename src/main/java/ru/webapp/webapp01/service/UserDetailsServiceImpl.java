package ru.webapp.webapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.webapp.webapp01.model.Role;
import ru.webapp.webapp01.model.User;
import ru.webapp.webapp01.repository.RoleRepository;
import ru.webapp.webapp01.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // «Пользователь» – это просто Object. В большинстве случаев он может быть
    //  приведен к классу UserDetails.
    // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(name);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public List<Role> listRoles(){
        return roleRepository.findAll();
    }

//    public User getId(Long id) {
//        return userRepository.findById(id).get();
//    }

    @Transactional
    public void add(User user){
        userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, User user){
        User editUser = userRepository.findById(id).get();
        editUser.setName(user.getName());
        editUser.setLastName(user.getLastName());
        editUser.setPassword(user.getPassword());
        editUser.setEmail(user.getEmail());
        return userRepository.save(editUser);
    }

    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public void registerUser(User user, String[] roles) {
        Set<Role> roleUser = Arrays.stream(roles)
                        .map(roleRepository::findByRole)
                                .collect(Collectors.toSet());
        user.setRoles(roleUser);
        userRepository.save(user);
    }
}
