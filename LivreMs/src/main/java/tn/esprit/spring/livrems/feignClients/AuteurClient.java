package tn.esprit.spring.livrems.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.starter.mysqlShared.dto.auteurDTO;

@FeignClient(name="AuteurMS")

public interface AuteurClient {

    @GetMapping("/api/auteurs/getById/{id}")
    auteurDTO getAuteurById(@PathVariable String id);
}
