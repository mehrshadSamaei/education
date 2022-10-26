package com.example.educationalinstitutions.restcontroller;

import com.example.educationalinstitutions.domain.Admin;
import com.example.educationalinstitutions.dto.AdminDto;
import com.example.educationalinstitutions.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AdminResource {
    @Autowired
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<AdminDto> findAdminById(@RequestParam Long id){
        return ResponseEntity.ok(
                adminService.findById(id)
        );
    }
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto){
        return ResponseEntity.ok(
                adminService.saveOrUpdate(adminDto)
        );
    }
    @PutMapping
    public ResponseEntity<AdminDto> updateAdmin(@RequestBody AdminDto adminDto){
        return ResponseEntity.ok(
                adminService.saveOrUpdate(adminDto)
        );
    }
    @DeleteMapping
    public void delete(@RequestBody AdminDto adminDto){
        Long id = adminDto.getId();
        adminService.deleteById(id);
    }
}
