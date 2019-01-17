package com.fc.fortune.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fc.fortune.Fortune;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class FortuneDao implements IFortuneDao{
	
		private ComboPooledDataSource dataSource;
		private JdbcTemplate template;
		
		@Autowired	
		public FortuneDao(ComboPooledDataSource dataSource) {
			this.template = new JdbcTemplate(dataSource);
		}
		
	
		@Override
		public int fortuneInsert(Fortune fortune) {
			int result = 0;
			String sql = "INSERT INTO fortune (sentence) values (?)";
			
			result = template.update(sql, fortune.getSentence());
			
			return result;
		}

		@Override
		public List<Fortune> fortuneSelectAll(){
			
			List<Fortune> fortunes = null;
			
			String sql = "SELECT * FROM fortune";

			fortunes = template.query(sql, new RowMapper<Fortune>() {

				@Override
				public Fortune mapRow(ResultSet rs, int rowNum) throws SQLException {
					Fortune fortune = new Fortune();
					fortune.setSentence(rs.getString("sentence"));
					return fortune;
				}
			
			});
		
			if(fortunes.isEmpty()) return null;
			
			return fortunes;
		}
		
		@Override
		public Fortune fortuneSelect(final Fortune fortune) {
			
			List<Fortune> fortunes = null;
			
			String sql = "SELECT * FROM fortune WHERE sentence = ?";
			
			fortunes = template.query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement pstmt) throws SQLException {
					pstmt.setString(1, fortune.getSentence());
				}
			}, new RowMapper<Fortune>() {

				@Override
				public Fortune mapRow(ResultSet rs, int rowNum) throws SQLException {
					Fortune fortune = new Fortune();
					fortune.setSentence(rs.getString("sentence"));
					
					return fortune;
				}
			
			});
		
			if(fortunes.isEmpty()) return null;
			
			return fortunes.get(0);
			
		}

		@Override
		public int fortuneUpdate(Fortune fortune) {
			int result = 0;
			String sql = "UPDATE fortune SET sentence = ? WHERE sentence = ?";
			
			result = template.update(sql, fortune.getSentence());
			
			return result;
			
		}

		@Override
		public int fortuneDelete(Fortune fortune) {
			int result = 0;
			String sql = "DELETE fortune WHERE sentence = ?";
			
			result = template.update(sql, fortune.getSentence());

			return result;
		}

}
