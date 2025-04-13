package tn.esprit.spring.auteurms.service;

import lombok.AllArgsConstructor;
import tn.starter.mongoShared.dto.auteurDTO;

import org.springframework.stereotype.Service;
import tn.esprit.spring.auteurms.entity.auteurEntity;
import tn.starter.mongoShared.service.IGenericServiceImpl;



@Service
@AllArgsConstructor
public class auteurServiceImp  extends IGenericServiceImpl<auteurDTO, auteurEntity> implements auteurService{
}