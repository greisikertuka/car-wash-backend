package com.carwash.service;

import com.carwash.model.Car;
import com.carwash.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@ApplicationScoped
public class CarService {

    @Inject
    CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.listAll();
    }

    @Transactional
    public void insertCar(Car car) {
        carRepository.persist(car);
    }

    @Transactional
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    public void update(Car car) {
        carRepository.getEntityManager().merge(car);
    }
}
