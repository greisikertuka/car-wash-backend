package com.carwash.repository;

import com.carwash.model.Owner;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OwnerRepository implements PanacheRepository<Owner> {
}
