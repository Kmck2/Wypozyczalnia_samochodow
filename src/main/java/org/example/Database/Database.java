package org.example.Database;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Database
{
    private Connection connection;

    void connectToDatabase() {
        String url = "jdbc:sqlite:database.db";

        connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            System.exit(-1);
        }

    }

    void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing the database " + e.getMessage());
            System.exit(-2);
        }

    }
    public void initializeDatabase() {
        File dbFile = new File("database.db");

        if (!dbFile.exists()) {
            try {
                if (dbFile.createNewFile()) {
                    connectToDatabase();
                    String createTableSQL = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, login TEXT, password TEXT, firstname TEXT, lastname TEXT, pesel TEXT, admin INTEGER)";
                    String carTableSQL = "CREATE TABLE cars (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "model TEXT," +
                            "mark TEXT," +
                            "color TEXT," +
                            "buyer_id INTEGER REFERENCES users(id)," +
                            "seller_id INTEGER REFERENCES users(id)," +
                            "image BLOB" +
                            ")";
                    try {
                        Statement stmt = connection.createStatement();
                        stmt.execute(createTableSQL);
                        Statement car = connection.createStatement();
                        car.execute(carTableSQL);
                    } catch (SQLException e) {
                        System.err.println("Error creating table: " + e.getMessage());
                        System.exit(-3);
                    }
                    closeConnection();
                }
            } catch (IOException e) {
                System.out.println("Error creating database file: " + e.getMessage());
                System.exit(-4);
            }
        }
    }
    public void addUser(String login, String password, String firstnane, String lastname, String pesel) {
        connectToDatabase();

        String insertUserSQL = "INSERT INTO users (login, password, firstname, lastname, pesel, admin) VALUES (?, ?, ?, ?, ?, 0)";
        try {
            PreparedStatement statement = connection.prepareStatement(insertUserSQL);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setString(3, firstnane);
            statement.setString(4, lastname);
            statement.setString(5, pesel);
            statement.executeUpdate();
            System.out.println("User inserted"); //test

        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
            System.exit(1);
        }
        closeConnection();
    }
        public boolean checkUsername(String username) {
        connectToDatabase();
        String selectUserSQL = "SELECT * FROM users WHERE login = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(selectUserSQL);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                closeConnection();
                return false;
            } else {
                closeConnection();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error Checking username: " + e.getMessage());
            System.exit(1);
        }
        closeConnection();
        return false;
    }



}
