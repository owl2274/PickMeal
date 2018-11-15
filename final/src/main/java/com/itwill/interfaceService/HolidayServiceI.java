package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Holiday;

public interface HolidayServiceI {
	List<Holiday> getHoliday(int rstNo);
	List<Holiday> getHolidayYearmon(Holiday holiday);
	int insertHoliday(Holiday holiday);
	int deleteHoliday(Holiday holiday);
}
