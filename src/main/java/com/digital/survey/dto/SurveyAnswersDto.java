package com.digital.survey.dto;

import java.util.Set;

/**
 * DTO class for survey_answers table.creating multiple record as per selected
 * possible answers
 */
public class SurveyAnswersDto {
	private long surveyQustionId;

	private long questionId;
	/**
	 * Question has multiple possible answers
	 */
	private Set<Long> answerList;

	public SurveyAnswersDto() {
		super();
	}

	/**
	 * @param surveyQustionId
	 * @param questionId
	 * @param answerList
	 */
	public SurveyAnswersDto(long surveyQustionId, long questionId, Set<Long> answerList) {
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
