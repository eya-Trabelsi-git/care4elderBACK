package tn.esprit.spring.servicems.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.servicems.entity.ServiceOffer;
import tn.esprit.spring.servicems.entity.ServiceClient;
import tn.esprit.spring.servicems.feignClients.ClientClient;
import tn.esprit.spring.servicems.repository.ServiceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements IServiceService {

    private final ServiceRepository repository;
    @Autowired(required = false)
    private ClientClient clientClient;

    @Autowired
    public ServiceServiceImpl(ServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ServiceOffer createService(ServiceOffer service) {
        return repository.save(service);
    }

    @Override
    public List<ServiceOffer> getAllServices() {
        return repository.findAll();
    }

    @Override
    public ServiceOffer getServiceById(Long id) {
        return repository.findById(id).orElse(null);
    }


}