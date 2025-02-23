package com.Ramanan.Project.Service;

import com.Ramanan.Project.Model.Division;
import com.Ramanan.Project.Repository.DivisionRepository;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class DivisionService {
    private final DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public List<Division> getAllDivisions() {
        long start = System.currentTimeMillis();
        System.out.println("Fetching from Database...");
        List<Division> divisions = divisionRepository.findAll();

        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + "ms");
        return divisions;
    }

    public Division createDivision(Division division) {
        return divisionRepository.save(division);
    }

    public Division updateDivision(Long id, Division division) {
        Division existingDivision = divisionRepository.findById(id).orElseThrow(() -> new RuntimeException("Division not found"));
        existingDivision.setName(division.getName());
        return divisionRepository.save(existingDivision);
    }

    public void deleteDivision(Long id) {
        divisionRepository.deleteById(id);
    }
}
