package com.thales.quicky.injections.dao;

import com.thales.quicky.injections.model.MonObjet;

public interface MonObjetDAO {
    MonObjet findByEmail(String email);
}
