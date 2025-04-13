package tn.esprit.spring.auteurms.mapper;
import tn.starter.mongoShared.dto.auteurDTO;
import tn.esprit.spring.auteurms.entity.auteurEntity;
import tn.starter.mongoShared.mapper.GenericMapper;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")

public interface AuteurMapper extends GenericMapper<auteurDTO, auteurEntity> {
}