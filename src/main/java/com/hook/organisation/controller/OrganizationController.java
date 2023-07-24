package com.hook.organisation.controller;

import com.hook.organisation.dto.OrganizationDto;
import com.hook.organisation.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Organization Service - Organization Controller",
        description = "OrganizationController Exposes REST APIs for Organization Service"
)
@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {

  private final OrganizationService organizationService;

  @Operation(
          summary = "Save Organization REST API",
          description = "Save Organization REST API is used to save organization object in to database "
  )
  @ApiResponse(responseCode = "201",
  description = "HTTP Status 201 CREATED")
  // Build save organization Rest api
  @PostMapping
  public ResponseEntity<OrganizationDto> saveOrganization(
      @RequestBody OrganizationDto organizationDto) {
    OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
    return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
  }

  @Operation(
          summary = "Get Organization REST API",
          description = "Get Organization REST API is used to Get organization object from a database "
  )
  @ApiResponse(responseCode = "200",
          description = "HTTP Status 200 OK")
  // Build get organization by code
  @GetMapping("/{code}")
  public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String code) {
    OrganizationDto organizationDto = organizationService.getOrganizationByCode(code);
    return ResponseEntity.ok(organizationDto);
  }

}
