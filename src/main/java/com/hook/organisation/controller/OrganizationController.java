package com.hook.organisation.controller;

import com.hook.organisation.dto.OrganizationDto;
import com.hook.organisation.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

  private final OrganizationService organizationService;

  // Build save organization Rest api
  @PostMapping
  public ResponseEntity<OrganizationDto> saveOrganization(
      @RequestBody OrganizationDto organizationDto) {
    OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
    return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
  }

  // Build get organization by code
  @GetMapping("/{code}")
  public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String code) {
    OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
    return ResponseEntity.ok(organizationDto);
  }

}
