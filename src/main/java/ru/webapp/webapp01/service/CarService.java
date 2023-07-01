package ru.webapp.webapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webapp.webapp01.model.Car;
import ru.webapp.webapp01.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public void add(Car car){
        carRepository.save(car);
    }

    public List<Car> listCars(){
        return carRepository.findAll();
    }

    public Car show(Long id){
        return carRepository.getOne(id);
    }

    public void update(Long id, Car updateCar){
      carRepository.getOne(id);
      carRepository.save(updateCar);
    }

    public void delete(Long id){
        carRepository.deleteById(id);
    }
}
