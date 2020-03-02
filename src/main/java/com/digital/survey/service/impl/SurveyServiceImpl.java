package com.digital.survey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dao.SurveyDao;
import com.digital.survey.dto.SurveyDto;
import com.digital.survey.service.SurveyService;

/**
 * Implementation of survey update, creation and fetch survey for the client
 * 
 * @author Anita Devdare
 * @since 1.0
 */
@Service
public class SurveyServiceImpl implements SurveyService {
	@Autowired
	SurveyDao surveyDao;

	/**
	 * This method will update last survey status as inactive and create new for the
	 * client
	 * 
	 * @param survey survey object return survey the created survey
	 */
	@Override
	public SurveyDto createSurvey(SurveyDto surveyDto) {

		return surveyDao.createSurvey(surveyDto);
	}

	@Override
	public SurveyDto getSurveyByActiveClientId(long clientId) {
		// TODO Auto-generated method stub
		return surveyDao.getSurveyByActiveClientId(clientId);
	}

}
