package com.digital.survey.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dao.SurveyResponseDao;
import com.digital.survey.dto.SurveyAnswersDto;
import com.digital.survey.dto.SurveyResponseDto;

import com.digital.survey.entity.SurveyAnswers;
import com.digital.survey.entity.SurveyResponse;
import com.digital.survey.repository.SurveyResponseRepository;

@Service
public class SurveyResponseDaoImpl implements SurveyResponseDao {
	@Autowired
	SurveyAnswersDaoImpl daoImpl;
	@Autowired
	SurveyResponseRepository persistSurveyRepository;

	/**
	 * used to convert SurveyResponseDto to SurveyResponse and create multiple
	 * record on the basis of selected answers
	 * 
	 * @param dto
	 * @param entity
	 */
	public void dtoToEntityConvert(SurveyResponseDto dto, SurveyResponse entity) {
		entity.setDeviceId(dto.getDeviceId());
		entity.setSurveyId(dto.getSurveyId());
		entity.setSurveyResponseId(dto.getSurveyResponseId());
		Set<SurveyAnswers> qustionsList = new HashSet<SurveyAnswers>();
		for (SurveyAnswersDto questions : dto.getQuestionList()) {
			SurveyAnswers surveyQuestions = new SurveyAnswers();
			Set<SurveyAnswers> surveyAnswersList = daoImpl.dtoToEntityConvert(questions, surveyQuestions);
			for (SurveyAnswers surveyAnswers : surveyAnswersList) {
				qustionsList.add(surveyAnswers);
			}
		}
		entity.setQuestionList(qustionsList);

	}

	/**
	 * user to save the survey response for multiple questions and their selected
	 * possible answers for the given device id.
	 * 
	 * @param surveyResponseDto
	 */

	public void saveSurveyResponse(SurveyResponseDto surveyResponseDto) {

		SurveyResponse survey = new SurveyResponse();
		dtoToEntityConvert(surveyResponseDto, survey);
		survey.setSurveySubmitted(new Date());
		Set<SurveyAnswers> questionSet = survey.getQuestionList();
		for (SurveyAnswers question : questionSet) {
			survey.setSurveyId(question.getQuestionId());
			survey.addQuestion(question);
		}
		persistSurveyRepository.save(survey);

	}

}
