package com.digital.survey.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dto.SurveyAnswersDto;
import com.digital.survey.entity.SurveyAnswers;
import com.digital.survey.repository.SurveyResponseRepository;

/**
 * The SurveyAnswersDaoImpl class is responsible for converting SurveyAnswersDto
 * to SurveyAnswers and creating the records on the basis of possible selected answers
 * for the respective question
 */
@Service
public class SurveyAnswersDaoImpl {
	@Autowired
	SurveyResponseRepository persistSurveyRepository;
/**
 * used to create multiple SurveyAnswers entities(record) on the basis of possible selected answers
 * for the respective question
 * 
 * @param dto
 * @param entity
 * @return SurveyAnswers list of created records
 */
	public Set<SurveyAnswers> dtoToEntityConvert(SurveyAnswersDto dto, SurveyAnswers entity) {

		Set<SurveyAnswers> answerList = new HashSet<SurveyAnswers>();
		for (Long answers : dto.getAnswerList()) {
			SurveyAnswers surveyAnswers = new SurveyAnswers();
			surveyAnswers.setQuestionId(dto.getQuestionId());
			surveyAnswers.setSurveyQustionId(dto.getSurveyQustionId());
			surveyAnswers.setAnswerId(answers);
			answerList.add(surveyAnswers);
		}
		return answerList;

	}

}
