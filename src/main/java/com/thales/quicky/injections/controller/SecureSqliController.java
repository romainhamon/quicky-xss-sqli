package com.thales.quicky.injections.controller;

import com.thales.quicky.injections.model.User;
import com.thales.quicky.injections.reposiroty.SecuredUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sqli")
public class SecureSqliController {

    private final DataSource dataSource;

    private final SecuredUserRepository securedUserRepository;

    public SecureSqliController(DataSource dataSource, SecuredUserRepository securedUserRepository) {
        this.dataSource = dataSource;
        this.securedUserRepository = securedUserRepository;
    }


    @GetMapping("/secured/prep")
    public String preparedStatement(Model model, @RequestParam(required = false) String input) throws Exception{
        List<User> usersFound = new ArrayList<>();

        Connection connection = null;
        PreparedStatement prepStatement = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();

            prepStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
            prepStatement.setString(1, input);
            rs = prepStatement.executeQuery();

            while(rs.next()){
                long id  = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                usersFound.add(new User(id, username, email, ""));
            }

            rs.close();
            prepStatement.close();
            connection.close();
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            try {
                if(prepStatement!=null) prepStatement.close();
                if(connection!=null) connection.close();
            } catch (Exception e){}
        }

        model.addAttribute("usersFound", usersFound);
        return "sqli";
    }

    @GetMapping("/secured/hibernate")
    public String hibernate(Model model, @RequestParam(required = false) String input) {
        model.addAttribute("usersFound", this.securedUserRepository.findAllByUsername(input));
        return "sqli";
    }



}
