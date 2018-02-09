package com.szw.trading.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.szw.trading.mybatis.entity.InvestmentSummary;
import com.szw.trading.mybatis.entity.InvestmentSummaryExample;


public interface InvestmentSummaryMapper {
	long countByExample(InvestmentSummaryExample example);

	int deleteByPrimaryKey(Long investmentId);

	int insert(InvestmentSummary record);

	int insertSelective(InvestmentSummary record);

	List<InvestmentSummary> selectByExample(InvestmentSummaryExample example);

	InvestmentSummary selectByPrimaryKey(Long investmentId);

	int updateByExampleSelective(@Param("record") InvestmentSummary record, @Param("example") InvestmentSummaryExample example);

	int updateByExample(@Param("record") InvestmentSummary record, @Param("example") InvestmentSummaryExample example);

	int updateByPrimaryKeySelective(InvestmentSummary record);

	int updateByPrimaryKey(InvestmentSummary record);

	List<InvestmentSummary> selectByParams(Map<String, Object> map);
}