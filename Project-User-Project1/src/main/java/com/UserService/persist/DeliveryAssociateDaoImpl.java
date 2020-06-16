package com.UserService.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.UserService.model.DeliveryAssociate;

@Component
public class DeliveryAssociateDaoImpl implements IDeliveryAssociateDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// insert data
	public int save(DeliveryAssociate deliveryassociate) {

		String sql = "INSERT INTO deliveryassociate (NAME,PHONENUMBER,EMAIL,LATITUDE,LONGITUDE,PANNO,DAIMAGE) VALUES(?,?,?,?,?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
				statement.setString(1, deliveryassociate.getName());
				statement.setString(2, deliveryassociate.getPhonenumber());
				statement.setString(3, deliveryassociate.getEmail());
				statement.setFloat(4, deliveryassociate.getLatitude());
				statement.setFloat(5, deliveryassociate.getLongitude());
				statement.setString(6, deliveryassociate.getPanno());
				statement.setString(7, deliveryassociate.getDaimage());

				return statement;
			}
		}, holder);
		return holder.getKey().intValue();
	}

	// get the data by id
	public DeliveryAssociate getRseResult(int id) {
		String sql = "SELECT ID, NAME, PHONENUMBER, EMAIL, STATUS, LATITUDE, LONGITUDE, PANNO, DAIMAGE FROM DELIVERYASSOCIATE WHERE ID = ?";
		DeliveryAssociate result = jdbcTemplate.query(sql, new Object[] { id },
				new ResultSetExtractor<DeliveryAssociate>() {
					@Override
					public DeliveryAssociate extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							DeliveryAssociate deliveryassociate = new DeliveryAssociate();
							deliveryassociate.setId(rs.getInt("ID"));
							deliveryassociate.setName(rs.getString("NAME"));
							deliveryassociate.setPhonenumber(rs.getString("PHONENUMBER"));
							deliveryassociate.setEmail(rs.getString("EMAIL"));
							deliveryassociate.setStatus(rs.getString("STATUS"));
							deliveryassociate.setLatitude(rs.getFloat("LATITUDE"));
							deliveryassociate.setLongitude(rs.getFloat("LONGITUDE"));
							deliveryassociate.setPanno(rs.getString("PANNO"));
							deliveryassociate.setDaimage(rs.getString("DAIMAGE"));
							return deliveryassociate;
						}
						return null;
					}
				});
		return result;
	}

	// update the data
	public DeliveryAssociate getResult1(int id, String phonenumber) {
		DeliveryAssociate result = getRseResult(id);
		if (result != null) {
			String sql = "UPDATE deliveryassociate SET PHONENUMBER = ? WHERE ID = ?";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
					statement.setString(1, phonenumber);
					statement.setInt(2, id);
					return statement;
				}
			}, holder);

		}
		return getRseResult(id);
	}

	// delete the data
	public DeliveryAssociate getResult2(int id) {
		DeliveryAssociate result = getRseResult(id);
		if (result != null) {
			String sql = "UPDATE deliveryassociate SET STATUS = ? WHERE ID = ?";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
					statement.setString(1, "inactive");
					statement.setInt(2, id);
					return statement;
				}
			}, holder);

		}
		return getRseResult(id);
	}

}
