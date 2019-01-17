package com.fc.fortune.service;

import java.util.List;

import com.fc.fortune.Fortune;

public interface IFortuneService {
	void fortuneRegister(Fortune fortune);
	List<Fortune> fortuneSearchAll();
	Fortune fortuneSearch(Fortune fortune);
	Fortune fortuneModify(Fortune fortune);
	void fortuneRemove(Fortune fortune);
}
