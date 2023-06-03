package com.hook.organisation.mapper;

import com.hook.organisation.dto.OrganizationDto;
import com.hook.organisation.entity.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

  OrganizationDto organizationToOrganizationDto(Organization organization);

  Organization organizationDtoToOrganization(OrganizationDto organizationDto);

}
