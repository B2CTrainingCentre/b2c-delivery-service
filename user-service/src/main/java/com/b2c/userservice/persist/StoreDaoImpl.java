package com.b2c.userservice.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.b2c.userservice.model.Store;

@Repository
public class StoreDaoImpl implements IStoreDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public long saveStore(Store store) {
		String sql = "INSERT INTO store (STORENAME, STORELICNO, STOREPANNO, STORELICENSEIMAGE, STOREADDRESS, STORECITY, "
				+ "STOREPINCODE, STORELAT, STORELONG, STOREPICIMAGENAME, STORECONTACTDETAILS, OWNERNAME, OWNERCONTACT, "
				+ "OWNEREMAIL, STORETYPE, STORESTATE, CREATEDBY, CREATEDDATE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				Timestamp timestamp = new Timestamp(date.getTime());
				Calendar cal = Calendar.getInstance();
				statement.setString(1, store.getStorename());
				statement.setString(2, store.getStorelicno());
				statement.setString(3, store.getStorepanno());
				statement.setString(4, store.getStorelicenseimage());
				statement.setString(5, store.getStoreaddress());
				statement.setString(6, store.getStorecity());
				statement.setString(7, store.getStorepincode());
				statement.setFloat(8, store.getStorelat());
				statement.setFloat(9, store.getStorelong());
				statement.setString(10, store.getStorepicimagename());
				statement.setString(11, store.getStorecontactdetails());
				statement.setString(12, store.getOwnername());
				statement.setString(13, store.getOwnercontact());
				statement.setString(14, store.getOwneremail());
				statement.setString(15, store.getStoretype());
				statement.setString(16, store.getStorestate());
				statement.setInt(17, store.getCreatedby());
				statement.setTimestamp(18, timestamp);

				return statement;
			}
		}, holder);
		return holder.getKey().intValue();
	}

	public Store getStoreRseResult(long id) {
		String sql = "SELECT ID, STORENAME, STORELICNO, STOREPANNO, STORELICENSEIMAGE, STOREADDRESS, STORECITY, STOREPINCODE,"
				+ "STORELAT, STORELONG, STOREPICIMAGENAME, STORECONTACTDETAILS, OWNERNAME, OWNERCONTACT, OWNEREMAIL, STATUS,"
				+ "STORETYPE, STORESTATE, CREATEDBY, CREATEDDATE FROM STORE WHERE ID = ?";
		Store result = jdbcTemplate.query(sql, new Object[] { id }, new ResultSetExtractor<Store>() {
			@Override
			public Store extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Store store = new Store();
					store.setId(rs.getLong("ID"));
					store.setStorename(rs.getString("STORENAME"));
					store.setStorelicno(rs.getString("STORELICNO"));
					store.setStorepanno(rs.getString("STOREPANNO"));
					store.setStorelicenseimage(rs.getString("STORELICENSEIMAGE"));
					store.setStoreaddress(rs.getString("STOREADDRESS"));
					store.setStorecity(rs.getString("STORECITY"));
					store.setStorepincode(rs.getString("STOREPINCODE"));
					store.setStorelat(rs.getFloat("STORELAT"));
					store.setStorelong(rs.getFloat("STORELONG"));
					store.setStorepicimagename(rs.getString("STOREPICIMAGENAME"));
					store.setStorecontactdetails(rs.getString("STORECONTACTDETAILS"));
					store.setOwnername(rs.getString("OWNERNAME"));
					store.setOwnercontact(rs.getString("OWNERCONTACT"));
					store.setOwneremail(rs.getString("OWNEREMAIL"));
					store.setStatus(rs.getString("STATUS"));
					store.setStoretype(rs.getString("STORETYPE"));
					store.setStorestate(rs.getString("STORESTATE"));
					store.setCreatedby(rs.getInt("CREATEDBY"));
					store.setCreateddate(rs.getTimestamp("CREATEDDATE"));

					return store;
				}
				return null;
			}
		});
		return result;
	}

	public Store updateStoreResult1(long id, String storename, String storelicno, String storepanno,
			String storelicenseimage, String storeaddress, String storecity, String storepincode, float storelat,
			float storelong, String storepicimagename, String storecontactdetails, String ownername,
			String ownercontact, String owneremail, String storetype, String storestate, int createdby) {
		Store result = getStoreRseResult(id);
		if (result != null) {
			String sql = "UPDATE store SET STORENAME = ?, STORELICNO = ?, STOREPANNO = ?, STORELICENSEIMAGE = ?, STOREADDRESS = ?, "
					+ "STORECITY = ?, STOREPINCODE = ?, STORELAT = ?, STORELONG = ?, STOREPICIMAGENAME = ?, STORECONTACTDETAILS = ?, "
					+ "OWNERNAME  = ?, OWNERCONTACT = ?, OWNEREMAIL = ?, STATUS = ?, STORETYPE = ?, STORESTATE = ?, CREATEDBY = ?, "
					+ "CREATEDDATE = ? WHERE ID = ?";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
					if (storename != null && storename.trim().length() > 0) {
						statement.setString(1, storename);
					} else {
						statement.setString(1, result.getStorename());
					}

					if (storelicno != null && storelicno.trim().length() > 0) {
						statement.setString(2, storelicno);
					} else {
						statement.setString(2, result.getStorelicno());
					}

					if (storepanno != null && storepanno.trim().length() > 0) {
						statement.setString(3, storepanno);
					} else {
						statement.setString(3, result.getStorepanno());
					}

					if (storelicenseimage != null && storelicenseimage.trim().length() > 0) {
						statement.setString(4, storelicenseimage);
					} else {
						statement.setString(4, result.getStorelicenseimage());
					}

					if (storeaddress != null && storeaddress.trim().length() > 0) {
						statement.setString(5, storeaddress);
					} else {
						statement.setString(5, result.getStoreaddress());
					}

					if (storecity != null && storecity.trim().length() > 0) {
						statement.setString(6, storecity);
					} else {
						statement.setString(6, result.getStorecity());
					}

					if (storepincode != null && storepincode.trim().length() > 0) {
						statement.setString(7, storepincode);
					} else {
						statement.setString(7, result.getStorepincode());
					}

					if (storelat != 0) {
						statement.setFloat(8, storelat);
					} else {
						statement.setFloat(8, result.getStorelat());
					}
					
					if (storelong != 0) {
						statement.setFloat(9, storelong);
					} else {
						statement.setFloat(9, result.getStorelong());
					}

					if (storepicimagename != null && storepicimagename.trim().length() > 0) {
						statement.setString(10, storepicimagename);
					} else {
						statement.setString(10, result.getStorepicimagename());
					}

					if (storecontactdetails != null && storecontactdetails.trim().length() > 0) {
						statement.setString(11, storecontactdetails);
					} else {
						statement.setString(11, result.getStorecontactdetails());
					}

					if (ownername != null && ownername.trim().length() > 0) {
						statement.setString(12, ownername);
					} else {
						statement.setString(12, result.getOwnername());
					}

					if (ownercontact != null && ownercontact.trim().length() > 0) {
						statement.setString(13, ownercontact);
					} else {
						statement.setString(13, result.getOwnercontact());
					}

					if (owneremail != null && owneremail.trim().length() > 0) {
						statement.setString(14, owneremail);
					} else {
						statement.setString(14, result.getOwneremail());
					}

					statement.setString(15, result.getStatus());

					if (storetype != null && storetype.trim().length() > 0) {
						statement.setString(16, storetype);
					} else {
						statement.setString(16, result.getStoretype());
					}

					if (storestate != null && storestate.trim().length() > 0) {
						statement.setString(17, storestate);
					} else {
						statement.setString(17, result.getStorestate());
					}

					statement.setInt(18, createdby);
					statement.setTimestamp(19, result.getCreateddate());
					statement.setLong(20, id);
					return statement;
				}
			}, holder);

		}
		return getStoreRseResult(id);
	}

	public Store deleteStoreResult2(long id) {
		Store result = getStoreRseResult(id);
		if (result != null) {
			String sql = "UPDATE store SET STATUS = ? WHERE ID = ?";
			KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					// TODO Auto-generated method stub
					PreparedStatement statement = con.prepareStatement(sql, new String[] { "ID" });
					statement.setString(1, "inactive");
					statement.setLong(2, id);
					return statement;
				}
			}, holder);

		}
		return getStoreRseResult(id);
	}

}
