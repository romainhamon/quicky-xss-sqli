package com.thales.quicky.injections.dao;

import com.thales.quicky.injections.model.User;

public interface MonObjetDAO {
    User findByEmail(String email);
}
