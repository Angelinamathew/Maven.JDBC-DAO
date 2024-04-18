package daos;

import models.Car;

import java.util.List;

public interface CarInterface {
    Car findById(int id);
     List<Car> findAll();
    boolean update(Car car);
    boolean create(Car car);
    boolean delete(int id);
}
