package com.Ramanan.Project.Service;

import com.Ramanan.Project.Model.Team;
import com.Ramanan.Project.Model.User;
import com.Ramanan.Project.Repository.TeamRepository;
import com.Ramanan.Project.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    @Cacheable(value = "teamsCache")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public List<Team> getTeamsByDivision(Long divisionId) {
        return teamRepository.findByDivisionId(divisionId);
    }

    @CacheEvict(value = "teamsCache", allEntries = true)
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
    @CacheEvict(value = "teamsCache", allEntries = true)
    public Team updateTeam(Long id, Team team) {
        Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Team not found"));
        existingTeam.setName(team.getName());
        existingTeam.setDivision(team.getDivision());
        return teamRepository.save(existingTeam);
    }
    @CacheEvict(value = "teamsCache", allEntries = true)
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    @Transactional
    public void removeUserFromTeam(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Team team = user.getTeam();

        if (team != null) {
            team.setStrength(team.getStrength() - 1);
            teamRepository.save(team);
        }

        user.setTeam(null);
        userRepository.save(user);
    }

}

