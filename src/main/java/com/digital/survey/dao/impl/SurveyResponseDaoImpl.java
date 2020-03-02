package com.digital.survey.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dao.DtoEntityConverter;
import com.digital.survey.dao.SurveyResponseDao;
import com.digital.survey.dto.SurveyQuestionsDto;
import com.digital.survey.dto.SurveyResponseDto;

import com.digital.survey.entity.SurveyAnswers;
import com.digital.survey.entity.SurveyResponse;
import com.digital.survey.repository.SurveyResponseRepository;

@Service
public class SurveyResponseDaoImpl implements SurveyResponseDao, DtoEntityConverter<SurveyResponseDto, SurveyResponse> {
	@Autowired
	SurveyQuestionsDaoImpl daoImpl;
	@Autowired
	SurveyResponseRepository persistSurveyRepository;

	@Override
	public void dtoToEntityConvert(SurveyResponseDto dto, SurveyResponse entity) {
		entity.setDeviceId(dto.getDeviceId());
		entity.setSurveyId(dto.getSurveyId());
		entity.setSurveyResponseId(dto.getSurveyResponseId());
		Set<SurveyAnswers> qustionsList = new HashSet<SurveyAnswers>();
		for (SurveyQuestionsDto questions : dto.getQuestionList()) {
			SurveyAnswers surveyQuestions = new SurveyAnswers();
		Set<SurveyAnswers> queList=daoImpl.dtoToEntityConvert(questions, surveyQuestions);
		for(SurveyAnswers ques:queList)
			qustionsList.add(ques);

		}
		entity.setQuestionList(qustionsList);

	}

	/*
	 * @Override public void entityToDtoConvert(SurveyResponseDto dto,
	 * SurveyResponse entity) { dto.setDeviceId(entity.getDeviceId());
	 * dto.setSurveyId(entity.getSurveyId());
	 * dto.setSurveyResponseId(entity.getSurveyResponseId());
	 * Set<SurveyQuestionsDto> qustionsList=new HashSet<SurveyQuestionsDto>();
	 * for(SurveyQuestions questions:entity.getQuestionList()) { SurveyQuestionsDto
	 * surveyQuestionsDto=new SurveyQuestionsDto();
	 * daoImpl.entityToDtoConvert(surveyQuestionsDto, questions);
	 * qustionsList.add(surveyQuestionsDto); } dto.setQuestionList(qustionsList);
	 * 
	 * }
	 */

	@Override
	public SurveyResponseDto persistSurvey(SurveyResponseDto surveyResponseDto) {

		
		SurveyResponse survey = new SurveyResponse();
		dtoToEntityConvert(surveyResponseDto, survey);
		
		Set<SurveyAnswers> questionSet = survey.getQuestionList();
		for (SurveyAnswers question : questionSet) {
			survey.setSurveyId(question.getQuestionId());

			survey.addQuestion(question);
			
			
			 
			/*
			 * Set<Long> ansewrSet1 =
			 * persistSurveyRepository.findAllById(question.getQuestionId()); for
			 * (SurveyAnswers ansewr : ansewrSet) { question.addAnswers(ansewr); }
			 */
		}

		SurveyResponse createdSurvey = persistSurveyRepository.save(survey);
		
		entityToDtoConvert(surveyResponseDto, createdSurvey);
		return surveyResponseDto;

		
	}

	@Override
	public void entityToDtoConvert(SurveyResponseDto dto, SurveyResponse entity) {
		// TODO Auto-generated method stub
		
	}

}
