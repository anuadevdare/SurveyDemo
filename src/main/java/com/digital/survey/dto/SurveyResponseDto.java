package com.digital.survey.dto;

import java.util.Set;
/**
 * DTO class for survey_response table
 */
public class SurveyResponseDto {

	private long surveyResponseId;

	private long surveyId;

	private long deviceId;
/**
 * 
 */
	private Set<SurveyAnswersDto> questionList;

	public SurveyResponseDto() {
		super();
	}

	/**
	 * @param surveyResponseId
	 * @param surveyId
	 * @param deviceId
	 * @param questionList
	 */
	public SurveyResponseDto(long surveyResponseId, long surveyId, long deviceId,
			Set<SurveyAnswersDto> questionList) {
		super();
		this.surveyResponseId = surveyResponseId;
		this.surveyId = surveyId;
		this.deviceId = deviceId;
		this.questionList = questionList;
	}

	/**
	 * @return the surveyResponseId
	 */
	public long getSurveyResponseId() {
		return surveyResponseId;
	}

	/**
	 * @param surveyResponseId the surveyResponseId to set
	 */
	public void setSurveyResponseId(long surveyResponseId) {
		this.surveyResponseId = surveyResponseId;
	}

	/**
	 * @return the surveyId
	 */
	public long getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the deviceId
	 */
	public long getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the questionList
	 */
	public Set<SurveyAnswersDto> getQuestionList() {
		return questionList;
	}

	/**
	 * @param questionList the questionList to set
	 */
	public void setQuestionList(Set<SurveyAnswersDto> questionList) {
		this.questionList = questionList;
	}

}
