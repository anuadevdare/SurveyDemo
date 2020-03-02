package com.digital.survey.dao.impl;

import org.springframework.stereotype.Component;

import com.digital.survey.dao.DtoEntityConverter;
import com.digital.survey.dto.AnswerDto;
import com.digital.survey.entity.Answer;

/**
 * The AnswerDaoImpl class is responsible for converting AnswerDto to Answer and
 * vice versa.
 */
@Component
public class AnswerDaoImpl implements DtoEntityConverter<AnswerDto, Answer> {
/**
 * used to convert AnswerDto to Answer
 * @param AnswerDto the DTO object
 * @param Answer the entity object
 * 
 */
	@Override
	public void dtoToEntityConvert(AnswerDto dto, Answer entity) {
		entity.setAnswerId(dto.getAnswerId());
		entity.setAnswerText(dto.getAnswerText());
		entity.setQuestionId(dto.getQuestionId());
	}
	/**
	 * used to convert Answer to AnswerDto
	 * @param AnswerDto the DTO object
	 * @param Answer the entity object
	 * 
	 */
	@Override
	public void entityToDtoConvert(AnswerDto dto, Answer entity) {
		dto.setAnswerId(entity.getAnswerId());
		dto.setAnswerText(entity.getAnswerText());
		dto.setQuestionId(dto.getQuestionId());
	}

}
