package com.digital.survey.dto;

import java.util.Set;

public class SurveyQuestionsDto {
	private long surveyQustionId;

	private long questionId;

	private Set<Long> answerList;

	public SurveyQuestionsDto() {
		super();
	}

	/**
	 * @param surveyQustionId
	 * @param questionId
	 * @param answerList
	 */
	public SurveyQuestionsDto(long surveyQustionId, long questionId, Set<Long> answerList) {
		super();
		this.surveyQustionId = surveyQustionId;
		this.questionId = questionId;
		this.answerList = answerList;
	}

	/**
	 * @return the surveyQustionId
	 */
	public long getSurveyQustionId() {
		return surveyQustionId;
	}

	/**
	 * @param surveyQustionId the surveyQustionId to set
	 */
	public void setSurveyQustionId(long surveyQustionId) {
		this.surveyQustionId = surveyQustionId;
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
	 * @return the answerList
	 */
	public Set<Long> getAnswerList() {
		return answerList;
	}

	/**
	 * @param answerList the answerList to set
	 */
	public void setAnswerList(Set<Long> answerList) {
		this.answerList = answerList;
	}

	
}
