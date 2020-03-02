package com.digital.survey.dao;

import com.digital.survey.dto.SurveyDto;

/**
 * Interface responsible to create the survey for multiple questions and their
 * possible answers for the particular client.if client has existing survey
 * then first updated existing survey status as inactive(false), and create the
 * new survey with the active status(true).also find the active survey for
 * the given client id.
 */
public interface SurveyDao {
	/**
	 * Used to create the survey for the particular client
	 * 
	 * @param surveyDto
	 * @return the created survey
	 */
	SurveyDto createSurvey(SurveyDto surveyDto);

	/**
	 * Used to get the active survey for the particular client
	 * 
	 * @param surveyDto
	 * @return the created survey
	 */
	SurveyDto getSurveyByActiveClientId(long clientId);
}
