package org.cleaning_rest.service.mapper;

import org.cleaning_rest.config.MappingConfig;
import org.cleaning_rest.domain.dto.response.CleaningResponse;
import org.cleaning_rest.domain.entity.Cleaning;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MappingConfig.class)
public interface CleaningMapper {

    List<CleaningResponse> toDtoList(List<Cleaning> cleanings);
}
