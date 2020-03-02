package com.digital.survey.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dao.DtoEntityConverter;
import com.digital.survey.dto.SurveyQuestionsDto;
import com.digital.survey.entity.SurveyAnswers;

@Service
public class SurveyQuestionsDaoImpl {

	public Set<SurveyAnswers> dtoToEntityConvert(SurveyQuestionsDto dto, SurveyAnswers entity) {
		entity.setQuestionId(dto.getQuestionId());
		entity.setSurveyQustionId(dto.getSurveyQustionId());
		Set<SurveyAnswers> answerList = new HashSet<SurveyAnswers>();
		for (Long answers : dto.getAnswerList()) {
			SurveyAnswers surveyAnswers = new SurveyAnswers();
			entity.setAnswerId(answers);
			answerList.add(surveyAnswers);
			/*
			 * SurveyAnswers surveyAnswers=new SurveyAnswers();
			 * daoImpl.dtoToEntityConvert(answers, surveyAnswers);
			 * answerList.add(surveyAnswers);
			 */

		}
		return answerList;

	}

	/*
	 * public void entityToDtoConvert(SurveyQuestionsDto dto, SurveyQuestions
	 * entity) { dto.setQuestionId(entity.getQuestionId());
	 * dto.setSurveyQustionId(entity.getSurveyQustionId()); Set<Long> answerList=new
	 * HashSet<Long>(); for(SurveyAnswers answers:entity.getAnswerList()) {
	 * SurveyAnswersDto surveyAnswersDto=new SurveyAnswersDto();
	 * daoImpl.entityToDtoConvert(surveyAnswersDto, answers);
	 * answerList.add(surveyAnswersDto);
	 * 
	 * } dto.setAnswerList(answerList);
	 * 
	 * }
	 */

}
