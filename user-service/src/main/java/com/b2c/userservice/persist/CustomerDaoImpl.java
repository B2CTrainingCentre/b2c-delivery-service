package com.b2c.userservice.persist;

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
import org.springframework.stereotype.Repository;

import com.b2c.userservice.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveCustomer(Customer customer) {
		String sql = "INSERT INTO customer (NAME, MOBILE, EMAIL) VALUES (?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
				statement.setString(1, customer.getName());
				statement.setString(2, customer.getMobile());
				statement.setString(3, customer.getEmail());
				return statement;
			}
		}, holder);
		return holder.getKey().intValue();
	}

	public Customer getCustomerRseResult(int id) {
		String sql = "SELECT ID, NAME, MOBILE, EMAIL, STATUS FROM CUSTOMER WHERE ID = ?";
		Customer result = jdbcTemplate.query(sql, new Object[] { id }, new ResultSetExtractor<Customer>() {
			@Override
			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt("ID"));
					customer.setName(rs.getString("NAME"));
					customer.setMobile(rs.getString("MOBILE"));
					customer.setEmail(rs.getString("EMAIL"));
					customer.setStatus(rs.getString("STATUS"));

					return customer;
				}
				return null;
			}
		});
		return result;
	}

	public Customer updateCustomerResult1(int id, String email) {
		Customer result = getCustomerRseResult(id);
		if (result != null) {
			String sql = "UPDATE customer SET EMAIL = ? WHERE ID = ?";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
					statement.setString(1, email);
					statement.setInt(2, id);
					return statement;
				}
			}, holder);

		}
		return getCustomerRseResult(id);
	}

	public Customer deleteCustomerResult2(int id) {
		Customer result = getCustomerRseResult(id);
		if (result != null) {
			String sql = "UPDATE customer SET STATUS = ? WHERE ID = ?";
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
		return getCustomerRseResult(id);
	}

}
