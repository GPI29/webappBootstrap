package ru.webapp.webapp01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.webapp.webapp01.model.Car;
import ru.webapp.webapp01.repository.CarRepository;

import javax.transaction.Transactional;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

//    @Transactional
//    public void add(Car car){
//        carRepository.save(car);
//    }

    public List<Car> listCars(){
        return carRepository.findAll();
    }

    @Transactional
    public Car findById(Long id) {
        Optional<Car> carResponse = carRepository.findById(id);
        Car car = carResponse.get();
        return car;
    }
//
//    public Car show(Long id){
//        return carRepository.getOne(id);
//    }

    @Transactional
    public Car updateCar(Long id, Car car){
        Car editCar = carRepository.findById(id).get();
        editCar.setModel(car.getModel());
        editCar.setMark(car.getMark());
        editCar.setYear(car.getYear());
        return carRepository.save(editCar);
    }

    @Transactional
    public void delete(Long id){
        carRepository.deleteById(id);
    }
}
