package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Holiday;
import com.itwill.interfaceDAO.HolidayDAOI;
import com.itwill.mapper.holidayMapper;

@Repository
public class HolidayDAO implements HolidayDAOI {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Holiday> getHoliday(int rstNo) {
		return sqlSession.getMapper(holidayMapper.class).getHoliday(rstNo);
	}

	@Override
	public int insertHoliday(Holiday holiday) {
		return sqlSession.getMapper(holidayMapper.class).insertHoliday(holiday);
	}

	@Override
	public List<Holiday> getHolidayYearmon(Holiday holiday) {
		return sqlSession.getMapper(holidayMapper.class).getHolidayYearmon(holiday);
	}

	@Override
	public int deleteHoliday(Holiday holiday) {
		return sqlSession.getMapper(holidayMapper.class).deleteHoliday(holiday);
	}

}
