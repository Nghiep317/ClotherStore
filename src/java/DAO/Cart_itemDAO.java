/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Cart_item;
import Models.DBContext;
import Models.Product;
import Models.ProductVariation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Cart_itemDAO extends DBContext{
     
    public ArrayList<Cart_item> getcart_item(int User_id){
        ArrayList<Cart_item> t = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Sql = "select * from cart_item where user_id=?";
        int cart_item_id, user_id, product_id, quantity;
        try {
          ps = connection.prepareStatement(Sql);
          ps.setInt(1, User_id);
          rs = ps.executeQuery();
          while(rs.next()) {
            cart_item_id = rs.getInt(1);
            user_id = rs.getInt(2);
            product_id = rs.getInt(3);
            quantity = rs.getInt(4);
            t.add(new Cart_item(cart_item_id, user_id, product_id, quantity));
          }
          rs.close();
          ps.close();
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
        return(t);
    }
    
    public Cart_item getByUserProduct(int uid, int pid){
        Cart_item c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String Sql = "select * from cart_item where user_id=? and product_id=?";
        try {
          ps = connection.prepareStatement(Sql);
          ps.setInt(1, uid);
          ps.setInt(2, pid);
          rs = ps.executeQuery();
          if(rs.next()) {
            c = new Cart_item();
            c.setCart_item_id(rs.getInt("cart_item_id"));
            c.setProduct_id(rs.getInt("product_id"));
            c.setUser_id(rs.getInt("user_id"));
            c.setQuantity(rs.getInt("quantity"));
          }
          rs.close();
          ps.close();
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
        return(c);
    }
    
    public void addtocart(int User_id, int Product_id, int Quantity){
        PreparedStatement ps = null;
        String Sql = "insert into cart_item (user_id, product_id, quantity) values (?,?,?)";
        try {
          ps = connection.prepareStatement(Sql);
          ps.setInt(1, User_id);
          ps.setInt(2, Product_id);
          ps.setInt(3, Quantity);
          ps.execute();
          ps.close();
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
    }
    
    public void deletecart_item(int ID){
        PreparedStatement ps = null;
        String Sql = "delete from cart_item where cart_item_id=?";
        try {
          ps = connection.prepareStatement(Sql);
          ps.setInt(1, ID);
          ps.execute();
          ps.close();
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
    }
    
    public void updateQuantity(int ID, int Quantity){
        PreparedStatement ps = null;
        String Sql = "update cart_item set quantity=? where cart_item_id=?";
        try {
          ps = connection.prepareStatement(Sql);
          ps.setInt(1, Quantity);
          ps.setInt(2, ID);
          ps.executeUpdate();
          ps.close();
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
    }
}
