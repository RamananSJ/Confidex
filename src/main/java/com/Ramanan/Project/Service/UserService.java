package com.Ramanan.Project.Service;


import com.Ramanan.Project.Model.User;
import com.Ramanan.Project.Repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;

@EnableCaching
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "usersCache")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByTeam(Long teamId) {
        return userRepository.findByTeamId(teamId);
    }

    @CacheEvict(value = "usersCache", allEntries = true)
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @CacheEvict(value = "usersCache", allEntries = true)
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setTeam(user.getTeam());
        return userRepository.save(existingUser);
    }
    @CacheEvict(value = "usersCache", allEntries = true)
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @CacheEvict(value = "usersCache", allEntries = true)
    public List<User> getUsersByDivision(Long divisionId) {
        return userRepository.findUsersByTeam_DivisionId(divisionId);
    }
}
