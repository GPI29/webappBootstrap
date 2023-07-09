package ru.webapp.webapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.webapp.webapp01.model.Role;
import ru.webapp.webapp01.model.User;
import ru.webapp.webapp01.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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

}
