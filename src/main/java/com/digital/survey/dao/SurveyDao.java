package com.digital.survey.dao;

import com.digital.survey.dto.SurveyDto;

public interface SurveyDao {
	SurveyDto createSurvey(SurveyDto survey);

	SurveyDto getSurveyByClientId(long clientId);
}
