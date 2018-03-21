package com.thales.quicky.injections.dao;

import com.thales.quicky.injections.model.MonObjet;

import java.sql.Connection;
import java.sql.DriverManager;

public class MonObjetDAOImpl implements MonObjetDAO {
    @Override
    public MonObjet findByEmail(String email) {
        MonObjet lang = new MonObjet();
        try {

            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/test";
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(myUrl, "root", "");

            connection.prepareStatement("SELECT * FROM Annuaire WHERE nom = ?");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return lang;
    }
}
