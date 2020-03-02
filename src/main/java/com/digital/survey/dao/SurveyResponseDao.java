package com.digital.survey.dao;

import com.digital.survey.dto.SurveyResponseDto;

public interface SurveyResponseDao {
	SurveyResponseDto persistSurvey(SurveyResponseDto survey);
}
