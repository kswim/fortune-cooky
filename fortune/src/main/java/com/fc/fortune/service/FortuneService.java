package com.fc.fortune.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fc.fortune.Fortune;
import com.fc.fortune.dao.FortuneDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Service
public class FortuneService implements IFortuneService {
	
	@Autowired
	FortuneDao dao;
	
	@Override
	public void fortuneRegister(Fortune fortune) {
		int result = dao.fortuneInsert(fortune);
		
		if(result == 0) {
			System.out.println("Insert Fail!");
		}else {
			System.out.println("Insert Success!");
		}

	}

	@Override
	public List<Fortune> fortuneSearchAll(){
		List<Fortune> result = dao.fortuneSelectAll();

		return result;
	}
	
	@Override
	public Fortune fortuneSearch(Fortune fortune) {
		Fortune result = dao.fortuneSelect(fortune);
		printFortune(result);
		
		return result;
	}

	@Override
	public Fortune fortuneModify(Fortune fortune) {
		
		int result = dao.fortuneUpdate(fortune);
		
		if(result == 0) {
			System.out.println("Modifying Fail!");
		}else {
			System.out.println("Modifying Success!");
		}
		
		return fortune;
	}
	
	@Override
	public void fortuneRemove(Fortune fortune) {
		int result = dao.fortuneDelete(fortune);
		
		if(result == 0) {
			System.out.println("Remove Fail!");
		}else {
			System.out.println("Remove Success!");
		}
	}
	
	private void printFortune(Fortune fortune) {
		System.out.print("Sentence:" + fortune.getSentence() + "\n");
	
	}

}