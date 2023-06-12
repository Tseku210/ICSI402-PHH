package com.example.pharmacy_management_system.DAO;

import com.example.pharmacy_management_system.entity.User;

public interface UserDAO {
    boolean addUser(User user);
    boolean removeUser(int id);
    boolean updateUser(User user);
}
