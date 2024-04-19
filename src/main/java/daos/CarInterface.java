package daos;

import models.Car;

import java.util.List;

public interface CarInterface {
    Car findById(int id);
    List<Car> findAll();
    Car update(Car car);
    boolean create(Car car);
    boolean delete(int id);
}
