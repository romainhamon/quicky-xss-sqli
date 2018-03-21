package com.thales.quicky.injections.controller;

import com.thales.quicky.injections.model.User;
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

@Controller
@RequestMapping("/sqli")
public class SqliController {

    private final DataSource dataSource;

    public SqliController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/error")
    public String errorBased(Model model, @RequestParam(required = false) String input) throws Exception{
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        //String sql = "SELECT * FROM user where username = \"" + input + "\"";
        String sql = "SELECT * FROM user where username = \"sdfsd\" OR 1=1";
        ResultSet rs = statement.executeQuery(sql);

        List<User> usersFound = new ArrayList<>();

        while(rs.next()){
            long id  = rs.getLong("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            usersFound.add(new User(id, username, email));
        }

        model.addAttribute("usersFound", usersFound);
        return "sqli";
    }

}
