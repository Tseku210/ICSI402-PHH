package com.example.pharmacy_management_system.DAO;

import com.example.pharmacy_management_system.entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{
    private static UserDAOImpl instance = null;
    private Connection connection;

    private UserDAOImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "");
    }

    public static UserDAOImpl getInstance() {
        if (instance == null) {
            try {
                instance = new UserDAOImpl();
            } catch(SQLException e) {
                throw new RuntimeException();
            }
        }

        return instance;
    }

    @Override
    public boolean addUser(User user) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO users (username, password, first_name, last_name, email, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getMail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getRole());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean removeUser(int id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean updateUser(User user) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ?, email = ?, phone = ?, role = ? WHERE id = ?");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getMail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getRole());
            statement.setInt(8, user.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
