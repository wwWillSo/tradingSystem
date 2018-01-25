package com.szw.trading.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szw.trading.mybatis.entity.Login;
import com.szw.trading.mybatis.entity.LoginExample;


public interface LoginMapper {
	long countByExample(LoginExample example);

	int deleteByPrimaryKey(Integer loginId);

	int insert(Login record);

	int insertSelective(Login record);

	List<Login> selectByExample(LoginExample example);

	Login selectByPrimaryKey(Integer loginId);

	int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

	int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

	int updateByPrimaryKeySelective(Login record);

	int updateByPrimaryKey(Login record);
}