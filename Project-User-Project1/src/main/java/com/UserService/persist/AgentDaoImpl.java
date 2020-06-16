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

import com.UserService.model.Agent;

@Component
public class AgentDaoImpl implements IAgentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// insert the data
	public int save(Agent agent) {

		String sql = "INSERT INTO agent (NAME,PHONENUMBER) VALUES(?, ?)";
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
				statement.setString(1, agent.getName());
				statement.setString(2, agent.getPhonenumber());
				// statement.setString(2, agent.getStatus());
				return statement;
			}
		}, holder);
		return holder.getKey().intValue();
	}

	// get the data by id
	public Agent getRseResult(int id) {
		String sql = "SELECT ID, NAME, PHONENUMBER, STATUS FROM AGENT WHERE ID = ?";
		Agent result = jdbcTemplate.query(sql, new Object[] { id }, new ResultSetExtractor<Agent>() {
			@Override
			public Agent extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Agent agent = new Agent();
					agent.setId(rs.getInt("ID"));
					agent.setName(rs.getString("NAME"));
					agent.setPhonenumber(rs.getString("PHONENUMBER"));
					agent.setStatus(rs.getString("STATUS"));
					return agent;
				}
				return null;
			}
		});
		return result;
	}

	// update the data
	public Agent getResult1(int id, String phonenumber) {
		Agent result = getRseResult(id);
		if (result != null) {
			String sql = "UPDATE agent SET PHONENUMBER = ? WHERE ID = ?";
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
	public Agent getResult2(int id) {
		Agent result = getRseResult(id);
		if (result != null) {
			String sql = "UPDATE agent SET STATUS = ? WHERE ID = ?";
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
