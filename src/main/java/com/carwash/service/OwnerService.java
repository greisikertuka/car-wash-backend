package com.carwash.service;

import com.carwash.model.Owner;
import com.carwash.repository.OwnerRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@ApplicationScoped
public class OwnerService {

    @Inject
    OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.listAll();
    }

    @Transactional
    public void insertOwner(Owner owner) {
        ownerRepository.persist(owner);
    }

    @Transactional
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Transactional
    public void update(Owner owner) {
        ownerRepository.getEntityManager().merge(owner);
    }
}
