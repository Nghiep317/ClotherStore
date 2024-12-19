/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author wvrtu
 */

import Models.Category;
import Models.Image;
import Models.Product;
import Models.ProductVariation;
import Models.Provider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends MyDAO {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product WHERE is_removed = 0";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setCategory(getCategoryById(rs.getInt("category_id")));
                product.setProvider(getProviderById(rs.getInt("provider_id")));
                product.setProductName(rs.getString("product_name"));
                product.setCoverImg(rs.getString("cover_img"));
                product.setDescription(rs.getString("description"));
                product.setRemoved(rs.getBoolean("is_removed"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public Product getProductById(int productId) {
        Product product = null;
        String query = "SELECT * FROM Product WHERE product_id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setCategory(getCategoryById(rs.getInt("category_id")));
                product.setProvider(getProviderById(rs.getInt("provider_id")));
                product.setProductName(rs.getString("product_name"));
                product.setCoverImg(rs.getString("cover_img"));
                product.setDescription(rs.getString("description"));
                product.setRemoved(rs.getBoolean("is_removed"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO Product (category_id, provider_id, product_name, cover_img, description, is_removed) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getCategory().getCategoryId());
            ps.setInt(2, product.getProvider().getProviderId());
            ps.setString(3, product.getProductName());
            ps.setString(4, product.getCoverImg());
            ps.setString(5, product.getDescription());
            ps.setBoolean(6, false); // Initially not removed
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        String query = "UPDATE Product SET category_id=?, provider_id=?, product_name=?, cover_img=?, "
                     + "description=? WHERE product_id=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getCategory().getCategoryId());
            ps.setInt(2, product.getProvider().getProviderId());
            ps.setString(3, product.getProductName());
            ps.setString(4, product.getCoverImg());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getProductId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        String query = "UPDATE Product SET is_removed = 1 WHERE product_id=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from product_category";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Provider> getAllProviders() {
        List<Provider> list = new ArrayList<>();
        String sql = "select * from provider";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Provider(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Category getCategoryById(int categoryId) {
        Category category = null;
        String query = "SELECT * FROM product_category WHERE category_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public Provider getProviderById(int providerId) {
        Provider provider = null;
        String query = "SELECT * FROM Provider WHERE provider_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, providerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                provider = new Provider();
                provider.setProviderId(rs.getInt("provider_id"));
                provider.setCompanyName(rs.getString("company_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provider;
    }
    
    public List<ProductVariation> getAllProductVariations(Product product) {
        List<ProductVariation> list = new ArrayList<>();
        String query = "select * from product_variation where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getProductId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductVariation variation = new ProductVariation();
                variation.setVariationId(rs.getInt("variation_id"));
                variation.setProduct(getProductById(rs.getInt("product_id")));
                variation.setColor(rs.getString("color"));
                variation.setSize(rs.getString("size"));
                variation.setPrice(rs.getDouble("price"));
                variation.setQuantity(rs.getInt("quantity"));
                variation.setRemoved(rs.getBoolean("is_removed"));
                list.add(variation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ProductVariation getProductVariation(int variationId) {
        ProductVariation variation = null;
        String query = "select * from product_variation where variation_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, variationId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                variation = new ProductVariation();
                variation.setVariationId(rs.getInt("variation_id"));
                variation.setProduct(getProductById(rs.getInt("product_id")));
                variation.setColor(rs.getString("color"));
                variation.setSize(rs.getString("size"));
                variation.setPrice(rs.getDouble("price"));
                variation.setQuantity(rs.getInt("quantity"));
                variation.setRemoved(rs.getBoolean("is_removed"));                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return variation;
    }
    
    public List<Image> getAllImages(Product product) {
        List<Image> list = new ArrayList<>();
        String query = "select * from product_img where product_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getProductId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Image img = new Image();
                img.setImgId(rs.getInt("product_img_id"));
                img.setProduct(getProductById(rs.getInt("product_id")));
                img.setImgUrl(rs.getString("img"));
                list.add(img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getProductsByCategory(int category_id) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product p inner join  product_category c on p.category_id = c.category_id where p.category_id =?";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, category_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt(2), rs.getString(9));
                list.add(new Product(rs.getInt(1), c, getProviderById(rs.getInt(3)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> array = new ArrayList<>();
        for (int i = start; i < end; i++) {
            array.add(list.get(i));
        }
        return array;
    }
    
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
//        product.getAllProducts();
//        System.out.println(productDAO.);
    }

    public List<Product> getAllProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

}
