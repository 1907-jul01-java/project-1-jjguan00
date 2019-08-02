package com.projectone.entities;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.projectone.models.Reimbursement;
import com.projectone.controllers.ReimbursementController;
public class ReimbursementDao {
	Connection connection;
	public ReimbursementDao(Connection connection) {
		this.connection = connection;
	}
	
	public void submitrequest(Reimbursement reimbursement){
		try {
			PreparedStatement pStatement = connection.prepareStatement("insert into reimbursements(id,context, money, status, username) values(?,?,?,?,?)");
			SecureRandom random = new SecureRandom();
			int num = 10000 + random.nextInt(90000);
			pStatement.setInt(1, num);
			pStatement.setString(2, reimbursement.getContext());
			pStatement.setInt(3, reimbursement.getMoney());
			pStatement.setString(4, reimbursement.getStatus());
			pStatement.setString(5, reimbursement.getUsername().replaceAll("^\"|\"$", ""));
			System.out.println(pStatement);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			System.out.println("Successfully created a reimbursement request");
		}
	}
	
    public List<Reimbursement> getAll() {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        Reimbursement reimbursement;
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from reimbursements");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String context = resultSet.getString("context");
            	int money = resultSet.getInt("money");
            	String status = resultSet.getString("status");
            	String username = resultSet.getString("username");
                reimbursement = new Reimbursement(id, context,money, status, username);
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {
        	e.getMessage();
        }
        return reimbursements;
    }
    
    public void deny(int id) {
        try {
        	PreparedStatement pStatement = connection.prepareStatement("Update reimbursements set status = 'denied' where id = ?");
        	pStatement.setInt(1, id);
        	System.out.println(pStatement);
            pStatement.executeUpdate();
        } catch (SQLException e) {
        	e.getMessage();
        }    	
        System.out.println("You denied a reimbursement request");
    }
    
    public void approve(int id) {
        try {
        	PreparedStatement pStatement = connection.prepareStatement("Update reimbursements set status = 'approved' where id = ?");
        	pStatement.setInt(1, id);
        	System.out.println(pStatement);
            pStatement.executeUpdate();
        } catch (SQLException e) {
        	e.getMessage();
        }    	
        System.out.println("You approved a reimbursement request");
    }
    
    public void destroy(int id) {
        try {
        	PreparedStatement pStatement = connection.prepareStatement("delete from reimbursements where id = ?");
        	pStatement.setInt(1, id);
        	System.out.println(pStatement);
            pStatement.executeUpdate();
        } catch (SQLException e) {
        	e.getMessage();
        }    	
        System.out.println("You deleted a reimbursement request");
    }
    
    public List<Reimbursement> getbyuser(String user) {
        List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
        Reimbursement reimbursement;
        try {
        	PreparedStatement statement = connection.prepareStatement("select * from reimbursements where username = ?");
        	statement.setString(1, user.replaceAll("^\"|\"$", ""));
        	System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String context = resultSet.getString("context");
            	int money = resultSet.getInt("money");
            	String status = resultSet.getString("status");
            	String username = resultSet.getString("username");
                reimbursement = new Reimbursement(id, context,money, status, username);
                reimbursements.add(reimbursement);
            }
        } catch (SQLException e) {
        	e.getMessage();
        }
        return reimbursements;
    }

}
