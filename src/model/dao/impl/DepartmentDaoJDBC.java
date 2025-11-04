package model.dao.impl;

import db.DBException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static model.dao.impl.EntityMapper.instantiateDepartment;

public class DepartmentDaoJDBC implements DepartmentDao {

    private final Connection connection;

    public DepartmentDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        String sql = "SELECT * FROM department WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return instantiateDepartment(resultSet);
            }
            return null;
        }
        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            List<Department> departments = new ArrayList<>();
            while (resultSet.next()) departments.add(instantiateDepartment(resultSet));
            return departments;
        }
        catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }
}
