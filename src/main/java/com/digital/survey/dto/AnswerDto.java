package com.digital.survey.dto;

import org.springframework.stereotype.Component;

import com.digital.survey.entity.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * DTO class for answer_master table
 *
 */
@Component
public class AnswerDto {

	private long answerId;

	@JsonIgnore
	private Question questionId;

	private String answerText;

	public AnswerDto() {
		super();
	}

	/**
	 * @param answerId
	 * @param questionId
	 * @param answerText
	 */
	public AnswerDto(long answerId, Question questionId, String answerText) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.answerText = answerText;
	}

	/**
	 * @return the answerId
	 */
	public long getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the questionId
	 */
	public Question getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the answerText
	 */
	public String getAnswerText() {
		return answerText;
	}

	/**
	 * @param answerText the answerText to set
	 */
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Override
	public String toString() {
		return "AnswerDto [answerId=" + answerId + ", questionId=" + questionId + ", answerText=" + answerText + "]";
	}

}
