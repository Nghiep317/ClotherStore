package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import Models.DBContext;
import Models.User;
import java.util.List;

public class UserDAO extends DBContext {

    public User getAccount(String email, String pass) {
        User user = null;
        boolean is_removed = false;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM [user] WHERE email=? AND password=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                int user_id = rs.getInt("user_id"); // Correct column name
                String username = rs.getString("username");
                String Email = rs.getString("email"); // Correct column name
                String Password = rs.getString("password"); // Correct column name
                String Role = rs.getString("role");
                user = new User(user_id, username, Password, Email, Role, is_removed);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception during resource cleanup
            }
        }

        return user;
    }

    public User getUserById(int id) {
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM user WHERE user_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                boolean is_removed = rs.getBoolean("is_removed");
                user = new User(user_id, username, password, email, role, is_removed);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception during resource cleanup
            }
        }

        return user;
    }

    public User updateUser(User user) {
        PreparedStatement ps = null;

        try {
            String sql = "UPDATE user SET username=?, password=?, email=? WHERE user_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getUser_id());

            int rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception during resource cleanupđéo
            }
        }

        return user;
    }

    public List<User> getAllAccount() {
        List<User> users = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM [user]";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt("user_id"); // Correct column name
                String username = rs.getString("username");
                String email = rs.getString("email"); // Correct column name
                String password = rs.getString("password"); // Correct column name
                String role = rs.getString("role");
                boolean is_removed = rs.getBoolean("is_removed"); // Retrieve is_removed from the result set
                User user = new User(user_id, username, password, email, role, is_removed);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception during resource cleanup
            }
        }

        return users;
    }

  public User registerAccount(User user) {
    try {
        String sql = "INSERT INTO [user](username, password, email, role, is_removed) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setString(4, user.getRole());
        ps.setBoolean(5, user.isIs_removed());

        int result = ps.executeUpdate();
        if (result > 0) {
            return user; // Trả về user nếu đăng ký thành công
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception
    }
    
    return null; // Trả về null nếu có lỗi xảy ra hoặc đăng ký không thành công
}


    public String randomString(int length) {
        Random random = new Random();
        String setOfCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder abc = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String ab = Character.toString(setOfCharacters.charAt(random.nextInt(setOfCharacters.length())));
            abc.append(ab);
        }
        return abc.toString();
    }

    public ArrayList<User> getAccounts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
        List<User> user = new UserDAO().getAllAccount();

        System.out.println("success " + user);
    }

    public void deleteUserByID(int userId) throws SQLException {
        String sql = "DELETE FROM [user] WHERE user_id = ?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception during resource cleanup
            }
        }
    }
}
