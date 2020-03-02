package com.digital.survey.dto;
/**
 * DTO class for survey_master table
 */
import java.util.Set;

public class SurveyDto {

	private long surveyId;

	private String surveyTitle;

	private long clientId;

	/**
	 * Represents to store all questions in the survey
	 */
	private Set<QuestionDto> questionList;

	public SurveyDto() {
		super();
	}

	/**
	 * @param surveyId
	 * @param surveyTitle
	 * @param clientId
	 * @param questionList
	 */
	public SurveyDto(long surveyId, String surveyTitle, long clientId, Set<QuestionDto> questionList) {
		super();
		this.surveyId = surveyId;
		this.surveyTitle = surveyTitle;
		this.clientId = clientId;
		this.questionList = questionList;
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
	 * @return the surveyTitle
	 */
	public String getSurveyTitle() {
		return surveyTitle;
	}

	/**
	 * @param surveyTitle the surveyTitle to set
	 */
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	/**
	 * @return the clientId
	 */
	public long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the questionList
	 */
	public Set<QuestionDto> getQuestionList() {
		return questionList;
	}

	/**
	 * @param questionList the questionList to set
	 */
	public void setQuestionList(Set<QuestionDto> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "SurveyDto [surveyId=" + surveyId + ", surveyTitle=" + surveyTitle + ", clientId=" + clientId
				+ ", questionList=" + questionList + "]";
	}

}
