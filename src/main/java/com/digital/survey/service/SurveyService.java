package com.digital.survey.service;

import com.digital.survey.dto.SurveyDto;

/**
 * Interface update the last survey for the client and generate new for the
 * client.fetch the active survey on the basis of client id
 * 
 * @author Anita Devdare
 * @since 1.0
 *
 */
public interface SurveyService {

	SurveyDto createSurvey(SurveyDto survey);

	SurveyDto getSurveyByClientId(long clientId);

}
