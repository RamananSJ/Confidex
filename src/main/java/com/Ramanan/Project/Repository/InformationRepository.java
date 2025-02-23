package com.Ramanan.Project.Repository;

import com.Ramanan.Project.Model.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information, Long> {
}
