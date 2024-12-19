/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author wvrtu
 */
import Models.Provider;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProviderDAO extends MyDAO {
    
    public List<Provider> getAllProviders() {
        List<Provider> providers = new ArrayList<>();
        String query = "SELECT * FROM Provider";
        
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setProviderId(rs.getInt("provider_id"));
                provider.setCompanyName(rs.getString("company_name"));
                providers.add(provider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        
        return providers;
    }
    
    public void addProvider(Provider provider) {
        String query = "INSERT INTO Provider (company_name) VALUES (?)";
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, provider.getCompanyName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    
    public void updateProvider(Provider provider) {
        String query = "UPDATE Provider SET company_name = ? WHERE provider_id = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, provider.getCompanyName());
            ps.setInt(2, provider.getProviderId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    
    public void deleteProvider(int providerId) {
        String query = "DELETE FROM Provider WHERE provider_id = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, providerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Create an instance of ProviderDAO
        ProviderDAO providerDAO = new ProviderDAO();

        // Test getAllProviders() method
        System.out.println("All Providers:");
        List<Provider> allProviders = providerDAO.getAllProviders();
        for (Provider provider : allProviders) {
            System.out.println(provider.getProviderId() + ": " + provider.getCompanyName());
        }

        // Test addProvider() method
        Provider newProvider = new Provider();
        newProvider.setProviderId(1);
        newProvider.setCompanyName("New Provider");
        providerDAO.addProvider(newProvider);
        System.out.println("\nNew Provider added.");

        for (Provider provider : allProviders) {
            System.out.println(provider.getProviderId() + ": " + provider.getCompanyName());
        }
//        // Test updateProvider() method
//        Provider providerToUpdate = allProviders.get(0); // Update the first provider
//        providerToUpdate.setCompanyName("Updated Company Name");
//        providerDAO.updateProvider(providerToUpdate);
//        System.out.println("\nProvider with ID " + providerToUpdate.getProviderId() + " updated.");
//
//        // Test deleteProvider() method
//        int providerIdToDelete = allProviders.get(1).getProviderId(); // Delete the second provider
//        providerDAO.deleteProvider(providerIdToDelete);
//        System.out.println("\nProvider with ID " + providerIdToDelete + " deleted.");
    }
}


