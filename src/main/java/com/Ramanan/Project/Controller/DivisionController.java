package com.Ramanan.Project.Controller;

import com.Ramanan.Project.Model.Division;
import com.Ramanan.Project.Service.DivisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/divisions")
public class DivisionController {
    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @GetMapping("/getDivisions")
    public ResponseEntity<List<Division>> getAllDivisions() {
        return ResponseEntity.ok(divisionService.getAllDivisions());
    }

    @PostMapping
    public ResponseEntity<Division> createDivision(@RequestBody Division division) {
        return ResponseEntity.ok(divisionService.createDivision(division));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Division> updateDivision(@PathVariable Long id, @RequestBody Division division) {
        return ResponseEntity.ok(divisionService.updateDivision(id, division));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDivision(@PathVariable Long id) {
        divisionService.deleteDivision(id);
        return ResponseEntity.noContent().build();
    }
}
