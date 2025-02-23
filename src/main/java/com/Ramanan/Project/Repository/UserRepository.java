package com.Ramanan.Project.Repository;


import com.Ramanan.Project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByTeamId(Long teamId);

    @Query("SELECT u FROM User u WHERE u.team.division.id = :divisionId")
    List<User> findUsersByTeam_DivisionId(@Param("divisionId") Long divisionId);


}

