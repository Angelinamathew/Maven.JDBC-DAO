package daos;

import models.Car;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class carDAO implements CarInterface{

    @Override
    public Car findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars WHERE id=" + id);

            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        List<Car> cars = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM cars;");

            if(rs.next()) {
                Car car = extractUserFromResultSet(rs);
                cars.add(car);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cars;
    }

    @Override
    public boolean update(Car car) {

        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars SET make=?, model=?, yearOfModel=?, color=? WHERE id=?");
            ps.setInt(1,car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYearOfModel());
            ps.setString(5, car.getColor());

            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean create(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO user VALUES (NULL, ?, ?, ?, ?)");
            ps.setInt(1, car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYearOfModel());
            ps.setString(5, car.getColor());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }
    private Car extractUserFromResultSet(ResultSet rs) throws SQLException {

        Car car = new Car();
        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYearOfModel(rs.getInt("yearOfModel"));
        car.setModel(rs.getString("color"));
        return car;
    }
}
