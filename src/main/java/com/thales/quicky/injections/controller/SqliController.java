package com.thales.quicky.injections.controller;

import com.thales.quicky.injections.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sqli")
public class SqliController {

    private final DataSource dataSource;

    public SqliController(DataSource dataSource) {
        this.dataSource = dataSource;
    }




    /** exemple utiliser **/
    // blabla' OR 1=1; -- commentaire
    @GetMapping("/error")
    public String errorBased(Model model, @RequestParam(required = false) String input) throws Exception{
        List<User> usersFound = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM user where username = '" + input + "'";
            rs = statement.executeQuery(sql);

            while(rs.next()){
                long id  = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                usersFound.add(new User(id, username, email, ""));
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
            } catch (Exception e){}
        }

        model.addAttribute("usersFound", usersFound);
        return "sqli";
    }

    @GetMapping("/blind")
    public String blindBased(Model model, @RequestParam(required = false) String input) {
        List<User> usersFound = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM user where username = '" + input + "'";
            rs = statement.executeQuery(sql);

            while(rs.next()){
                long id  = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                usersFound.add(new User(id, username, email, ""));
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            try {
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
            } catch (Exception e){}
        }

        model.addAttribute("usersFound", usersFound);
        return "sqli-blind";
    }

    @GetMapping("/time")
    public String timeBased(Model model, @RequestParam(required = false) String input) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            String sql = "SELECT * FROM user where username = '" + input + "'";
            rs = statement.executeQuery(sql);

            while(rs.next()){
                long id  = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            try {
                if(statement!=null) statement.close();
                if(connection!=null) connection.close();
            } catch (Exception e){}
        }

        return "sqli-blind-time";
    }

}
