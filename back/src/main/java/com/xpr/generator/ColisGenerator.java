package com.xpr.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ColisGenerator implements IdentifierGenerator {

	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object)
	        throws HibernateException {

	    String prefix = "XPR1032MA";
	    Connection connection = session.connection();

	    try {
	        Statement statement=connection.createStatement();

	        ResultSet rs=statement.executeQuery("select count(num_commande) as num_commande from colis");
	        
	        
	        if(rs.next())
	        {
	            int id=rs.getInt(1)+10000;
	            String generatedId = prefix  +"-"+new Integer(id).toString();
	            return generatedId;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	

	    return null;
	
	}	

		
}
