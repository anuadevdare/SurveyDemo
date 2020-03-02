package com.digital.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dao.SurveyResponseDao;
import com.digital.survey.dto.SurveyResponseDto;
import com.digital.survey.service.SurveyReponseService;

@Service
public class SurveyReponseServiceImpl implements SurveyReponseService {

	@Autowired
	SurveyResponseDao surveyResponseDao;

	@Override
	public void saveSurveyResponse(SurveyResponseDto persistSurvey) {

		surveyResponseDao.saveSurveyResponse(persistSurvey);

	}

}
