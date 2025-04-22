package tn.esprit.spring.servicems.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.servicems.entity.ServiceOffer;
import tn.esprit.spring.servicems.entity.ServiceClient;
import tn.esprit.spring.servicems.service.IServiceService;
import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final IServiceService service;

    public ServiceController(IServiceService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceOffer create(@RequestBody ServiceOffer serviceOffer) {
        return service.createService(serviceOffer);
    }

    @GetMapping
    public List<ServiceOffer> getAll() {
        return service.getAllServices();
    }

    @GetMapping("/{id}")
    public ServiceOffer getById(@PathVariable Long id) {
        return service.getServiceById(id);
    }

}