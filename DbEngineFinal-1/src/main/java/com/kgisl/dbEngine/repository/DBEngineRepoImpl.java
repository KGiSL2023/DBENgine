package com.kgisl.dbEngine.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class DBEngineRepoImpl implements DBEngineRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Map<String, String> fetchColumnType(String tableName, String dbName) {
		
		String query = "SELECT COLUMN_NAME, DATA_TYPE, CHARACTER_MAXIMUM_LENGTH FROM information_schema.columns "
				+ "WHERE table_schema =  '"+dbName+"' and table_name = '"+tableName+"'";
		
		return jdbcTemplate.query(query, new ResultSetExtractor<Map<String,String>>(){
	         public Map<String,String> extractData(ResultSet rs) throws SQLException, DataAccessException {
	        	 Map<String,String> columnDataTypeMapper = new HashMap<String,String>();  
	             while(rs.next()){  
	            	 
	            	columnDataTypeMapper.put(rs.getString("COLUMN_NAME"),rs.getString("DATA_TYPE"));
	                  
	             }
	             return columnDataTypeMapper;  
	          }    	  
	       });
		
		
	}

	public void executeQuery(String insertionQuery) {
	
		jdbcTemplate.execute(insertionQuery);
		
	}

}
