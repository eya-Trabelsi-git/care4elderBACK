package tn.esprit.spring.auteurms.controller;

import org.springframework.web.bind.annotation.*;
import tn.starter.mongoShared.dto.auteurDTO;
import tn.starter.mongoShared.controller.GenericController;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/auteurs")
public class auteurController  extends GenericController<auteurDTO> {

}