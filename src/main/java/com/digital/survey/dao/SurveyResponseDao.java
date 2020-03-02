package com.digital.survey.dao;

import com.digital.survey.dto.SurveyResponseDto;

/**
 * Interface responsible to save the survey response for multiple questions and
 * their selected possible answers for the given device id.
 */
public interface SurveyResponseDao {
	/**
	 * Used to save the survey response for the given device id
	 * 
	 * @param surveyResponseDto
	 */
	void saveSurveyResponse(SurveyResponseDto surveyResponseDto);
}
