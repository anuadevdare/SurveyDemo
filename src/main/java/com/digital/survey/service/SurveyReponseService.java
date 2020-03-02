package com.digital.survey.service;

import com.digital.survey.dto.SurveyResponseDto;
/**
 * Interface responsible to save the survey response for multiple questions and
 * their selected possible answers for the given device id.
 *
 */
public interface SurveyReponseService {

	void saveSurveyResponse(SurveyResponseDto survey);
}
