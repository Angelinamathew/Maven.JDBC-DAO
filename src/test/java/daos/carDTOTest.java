package daos;

import models.Car;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class carDTOTest {
    @Test
    public void testById() {
        carDAO DAO = new carDAO();
        Car car = DAO.findById(1);
        Assert.assertEquals(1,car.getId());
    }

    @Test
    public void testFindAll() {
        carDAO CAO = new carDAO();

        List<Car> cars = CAO.findAll();
        Assert.assertFalse(cars.isEmpty());
    }

    @Test
    public void testUpdate() {
        Car car = new Car(1, "Toyota", "Corolla", 2020, "Blue");
        carDAO DAO = new carDAO();
        Car updated = DAO.update(car);
        Assert.assertEquals(updated.getYearOfModel(), car.getYearOfModel());
    }

    @Test
    public void testCreate() {
        Car car = new Car("Honda", "CR_V", 2020, "Silver");
        carDAO DAO = new carDAO();
        DAO.create(car);
        Assert.assertEquals(1, DAO.findAll().size());


    }
}
