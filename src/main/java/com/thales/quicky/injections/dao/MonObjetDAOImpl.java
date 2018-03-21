package com.thales.quicky.injections.dao;

import com.thales.quicky.injections.model.User;

import java.sql.Connection;
import java.sql.DriverManager;

public class MonObjetDAOImpl implements MonObjetDAO {
    @Override
    public User findByEmail(String email) {
        return null;
    }
}
