package com.hook.organisation.service.impl;

import com.hook.organisation.dto.OrganizationDto;
import com.hook.organisation.entity.Organization;
import com.hook.organisation.mapper.OrganizationMapper;
import com.hook.organisation.repository.OrganizationRepository;
import com.hook.organisation.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

  private final OrganizationRepository organizationRepository;
  private final OrganizationMapper organizationMapper;

  @Override
  public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
    // convert OrganizationDto to Organization entity
    Organization organization = organizationMapper.organizationDtoToOrganization(organizationDto);

    // save to db
    Organization savedOrganization = organizationRepository.save(organization);

    // return savedOrganization converted to dto
    return organizationMapper.organizationToOrganizationDto(savedOrganization);
  }


  @Override
  public OrganizationDto getOrganizationByCode(String organizationCode) {

    Organization organization = organizationRepository.findByOrganizationCode(
        organizationCode);
    return organizationMapper.organizationToOrganizationDto(organization);

  }
}
