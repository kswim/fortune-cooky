package com.fc.fortune.dao;

import java.util.List;

import com.fc.fortune.Fortune;

public interface IFortuneDao {

	int fortuneInsert(Fortune fortune);	
	List<Fortune> fortuneSelectAll();
	Fortune fortuneSelect(Fortune fortune);
	int fortuneUpdate(Fortune fortune);
	int fortuneDelete(Fortune fortune);
	
}
