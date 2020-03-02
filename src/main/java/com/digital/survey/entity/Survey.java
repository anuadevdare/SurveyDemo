package com.digital.survey.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Entity class for Survey
 * 
 * @author Anita Devdare
 * @since 1.0
 */
@Entity
@Table(name = "SURVEY_MASTER")
public class Survey implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEY_ID", columnDefinition = "BIGINT", length = 10)
	private long surveyId;

	/**
	 * Represents title for the survey
	 */
	@Column(name = "SURVEY_TITLE")
	private String surveyTitle;
	/**
	 * Represents status of the survey column
	 */

	@Column(name = "IS_ACTIVE", columnDefinition = "boolean default true")
	private boolean active;
	/**
	 * Represents client for fetching the survey
	 */
	@Column(name = "CLIENT_ID", nullable = false)
	private long clientId;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date surveyCreated;
	/**
	 * Represents to store questions in the survey
	 */
	@OneToMany(mappedBy = "surveyId", cascade = CascadeType.ALL)
	private Set<Question> questionList;

	public Survey() {
		super();
	}

	/**
	 * @param surveyId
	 * @param surveyTitle
	 * @param active
	 * @param clientId
	 * @param surveyCreated
	 * @param questionList
	 */
	public Survey(long surveyId, String surveyTitle, boolean active, long clientId, Date surveyCreated,
			Set<Question> questionList) {
		super();
		this.surveyId = surveyId;
		this.surveyTitle = surveyTitle;
		this.active = active;
		this.clientId = clientId;
		this.surveyCreated = surveyCreated;
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
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
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
	 * @return the surveyCreated
	 */
	public Date getSurveyCreated() {
		return surveyCreated;
	}

	/**
	 * @param surveyCreated the surveyCreated to set
	 */
	public void setSurveyCreated(Date surveyCreated) {
		this.surveyCreated = surveyCreated;
	}

	/**
	 * @return the questionList
	 */
	public Set<Question> getQuestionList() {
		return questionList;
	}

	/**
	 * @param questionList the questionList to set
	 */
	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}

	public void addQuestion(Question question) {
		if (question != null) {
			if (questionList == null) {
				questionList = new HashSet<>();
			}
			question.setSurveyId(this);
			questionList.add(question);

		}
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", surveyTitle=" + surveyTitle + ", active=" + active + ", clientId="
				+ clientId + ", questionList=" + questionList + "]";
	}

}
