package com.example.serverapp.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@RestController()
public class MsgController 
{
    @Autowired
    private Environment env;

    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public String postData(@RequestBody String data) 
    {
        return WriteToSql(data);
    }

    private String WriteToSql(String message)
    {

        Connection connection = null;
        Statement stmt = null;
        try
        {
            String connectionUrl = env.getProperty("connectionstring");
            
            connection = DriverManager.getConnection(connectionUrl);
             
            stmt = connection.createStatement();
            stmt.execute("Insert into msg.[Message] ([Message]) Values ('" + message +"')");
        }
        catch (Exception e) {
            e.printStackTrace();
            message = "Failed sending: " + message;
        }finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return message;
    }

}