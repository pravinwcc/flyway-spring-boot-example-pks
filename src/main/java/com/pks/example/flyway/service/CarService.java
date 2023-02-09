package com.pks.example.flyway.service;

import com.pks.example.flyway.entity.Car;
import com.pks.example.flyway.repository.CarRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;
    
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {

        return carRepository.findAll();
    }

    public Car findById(UUID uuid) {
        return carRepository.findById(uuid).orElseThrow(() -> new NoSuchElementException());
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(UUID uuid) {

        carRepository.deleteById(uuid);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    public boolean existById(UUID uuid) {
        return carRepository.existsById(uuid);
    }
}
