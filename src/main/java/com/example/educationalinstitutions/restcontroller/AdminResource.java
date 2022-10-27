package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.domain.Admin;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.dto.search.AdminSearch;
import com.example.educationalinstitutions.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminResource {
    @Autowired
    private final AdminService adminService;

    @GetMapping("/find-by-id-admin")
    public ResponseEntity<AdminDto> findAdminById(@RequestParam Long id) {
        return ResponseEntity.ok(
                adminService.findById(id)
        );
    }
    @GetMapping("/list-admin")
    public ResponseEntity<List<AdminDto>> listAllAdmins(){
        return ResponseEntity.ok(
                adminService.findAll()
        );
    }

    @PostMapping("/save-admin")
    public void createAdmin(@RequestBody @Valid AdminDto adminDto) {
        ResponseEntity.ok(
                adminService.saveOrUpdate(adminDto)
        );
    }

    @PutMapping("/update-admin")
    public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto) {
        return ResponseEntity.ok(
                adminService.saveOrUpdate(adminDto)
        );
    }

    @DeleteMapping("/delete-admin")
    public void delete(@RequestBody AdminDto adminDto) {
        Long id = adminDto.getId();
        adminService.deleteById(id);
    }

    @PostMapping("/search-admin")
    public ResponseEntity<List<AdminDto>> advanceSearch(@RequestBody AdminSearch adminSearch) {
        return ResponseEntity.ok(
                adminService.findAllAdvanceSearch(adminSearch)
        );
    }
}
