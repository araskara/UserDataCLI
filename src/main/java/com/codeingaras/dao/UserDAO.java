package com.codeingaras.dao;

import com.codeingaras.db.DatabaseConnection;
import com.codeingaras.model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDAO {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO users (name) VALUES (?)";
        try(Connection conn = DatabaseConnection.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, user.getName());
            pstmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void deleteUser(int id){
        String sql = "DELETE FROM users WHERE id = ?";
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, id);
            int deletedId = pstmt.executeUpdate();
            if(deletedId > 0){
                System.out.println("User with id " + id + " has been deleted.");
            } else {
                System.out.println("No user found with ID " + id);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public void updateUser(int id, String reName) {
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, reName);
            pstmt.setInt(2, id);
            int updatedName = pstmt.executeUpdate();
            if(updatedName > 0){
                System.out.println("User with id " + id + " has been Updated.");
            } else {
                System.out.println("No user found with ID " + id + " for Updating");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }




    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try(Connection conn = DatabaseConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
        )
        {
            while (rs.next()){

                users.add(new User(rs.getInt("id"), rs.getString("name")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }



}



