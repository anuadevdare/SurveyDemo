package com.digital.survey.dao.impl;

import java.util.HashSet;
import java.util.Set;

import com.digital.survey.dao.DtoEntityConverter;
import com.digital.survey.dto.AnswerDto;
import com.digital.survey.dto.QuestionDto;
import com.digital.survey.entity.Answer;
import com.digital.survey.entity.Question;

/**
 * The QuestionDaoImpl class is responsible for converting QuestionDto to
 * Question and vice versa.
 */

public class QuestionDaoImpl implements DtoEntityConverter<QuestionDto, Question> {
	AnswerDaoImpl dao = new AnswerDaoImpl();

	/**
	 * used to convert QuestionDto to Question
	 * 
	 * @param QuestionDto the DTO object
	 * @param Question    the entity object
	 * 
	 */
	@Override
	public void dtoToEntityConvert(QuestionDto dto, Question entity) {

		entity.setQuestionId(dto.getQuestionId());
		entity.setQuestionText(dto.getQuestionText());
		entity.setType(dto.getType());
		Set<Answer> answers = new HashSet<Answer>();
		for (AnswerDto ans : dto.getAnswerList()) {
			Answer ansEntity = new Answer();
			dao.dtoToEntityConvert(ans, ansEntity);
			answers.add(ansEntity);
		}
		entity.setAnswerList(answers);
	}
	/**
	 * used to convert Question to QuestionDto
	 * 
	 * @param QuestionDto the DTO object
	 * @param Question    the entity object
	 * 
	 */

	@Override
	public void entityToDtoConvert(QuestionDto dto, Question entity) {
		dto.setQuestionId(entity.getQuestionId());
		dto.setQuestionText(entity.getQuestionText());
		dto.setType(entity.getType());
		Set<AnswerDto> answers = new HashSet<AnswerDto>();
		for (Answer ans : entity.getAnswerList()) {
			AnswerDto ansDto = new AnswerDto();
			dao.entityToDtoConvert(ansDto, ans);
			answers.add(ansDto);
		}
		dto.setAnswerList(answers);

	}

}
