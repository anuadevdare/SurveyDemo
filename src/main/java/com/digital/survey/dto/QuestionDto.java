package com.digital.survey.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

/**
 * DTO class for question_master table
 */
public class QuestionDto {

	private long questionId;

	private String questionText;

	private String type;

	private Set<AnswerDto> answerList;

	public QuestionDto() {
		super();
	}

	/**
	 * @param questionId
	 * @param questionText
	 * @param type
	 * @param answerList
	 */
	public QuestionDto(long questionId, String questionText, String type, Set<AnswerDto> answerList) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.type = type;
		this.answerList = answerList;
	}

	/**
	 * @return the questionId
	 */
	public long getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the answerList
	 */
	public Set<AnswerDto> getAnswerList() {
		return answerList;
	}

	/**
	 * @param answerList the answerList to set
	 */
	public void setAnswerList(Set<AnswerDto> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "QuestionDto [questionId=" + questionId + ", questionText=" + questionText + ", type=" + type
				+ ", answerList=" + answerList + "]";
	}

}
