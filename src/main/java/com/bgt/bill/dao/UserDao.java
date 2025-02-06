//package com.bgt.bill.dao;
//
//import com.bgt.bill.entity.User;
//import com.bgt.bill.util.DatabaseConnectionManager;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//// 假设数据库中有一个名为 users 的表，包含 id、name 和 age 字段
//public class UserDao {
//    // 插入数据
//    public void insertUser(String name, int age) {
//        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
//        try (Connection conn = DatabaseConnectionManager.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, name);
//            pstmt.setInt(2, age);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 查询数据
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (Connection conn = DatabaseConnectionManager.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                users.add(new User(id, name, age));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    // 更新数据
//    public void updateUser(int id, String name, int age) {
//        String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
//        try (Connection conn = DatabaseConnectionManager.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, name);
//            pstmt.setInt(2, age);
//            pstmt.setInt(3, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 删除数据
//    public void deleteUser(int id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (Connection conn = DatabaseConnectionManager.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
