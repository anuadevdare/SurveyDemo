package com.digital.survey.service;

import com.digital.survey.dto.SurveyDto;

/**
 * Interface responsible to create the survey for multiple questions and their
 * possible answers for the particular client.if client has existing survey
 * then first updated existing survey status as inactive(false), and create the
 * new survey with the active status(true).also find the active survey for
 * the given client id.
 * 
 * @author Anita Devdare
 * @since 1.0
 *
 */
public interface SurveyService {

	SurveyDto createSurvey(SurveyDto survey);

	SurveyDto getSurveyByActiveClientId(long clientId);

}
