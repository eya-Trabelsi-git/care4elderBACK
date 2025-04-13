package tn.esprit.spring.livrems.mapper;
import org.mapstruct.Mapper;


import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tn.esprit.spring.livrems.entity.Livre;
import tn.starter.mysqlShared.dto.LivreDTO;
import tn.starter.mysqlShared.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface LivreMapper extends GenericMapper<LivreDTO, Livre> {
    @Mapping(target = "id", ignore = true) // Prevent overwriting the ID
    void updateEntityFromDto(LivreDTO dto, @MappingTarget Livre entity);
}
