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
 * Entity class for saving survey response
 * 
 * @author Anita Devdare
 * @since 1.0
 */
@Entity
@Table(name = "SURVEY_RESPONSE")
public class SurveyResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Represents composite primary column
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SURVEY_RESPONSE_ID")
	private long surveyResponseId;
	
	@Column(name = "SURVEY_ID", columnDefinition = "BIGINT", length = 10)
	private long surveyId;

	@Column(name = "DEVICE_ID", columnDefinition = "BIGINT", length = 20)
	private long deviceId;

	@OneToMany(mappedBy = "persistSurveyId", cascade = CascadeType.ALL)
	private Set<SurveyAnswers> questionList;
	
	@Basic
	@Temporal(TemporalType.DATE)
	private Date surveySubmitted;

	public SurveyResponse() {
		super();
	}

	/**
	 * @param surveyResponseId
	 * @param surveyId
	 * @param deviceId
	 * @param questionList
	 * @param surveySubmitted
	 */
	public SurveyResponse(long surveyResponseId, long surveyId, long deviceId, Set<SurveyAnswers> questionList,
			Date surveySubmitted) {
		super();
		this.surveyResponseId = surveyResponseId;
		this.surveyId = surveyId;
		this.deviceId = deviceId;
		this.questionList = questionList;
		this.surveySubmitted = surveySubmitted;
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
	public Set<SurveyAnswers> getQuestionList() {
		return questionList;
	}

	/**
	 * @param questionList the questionList to set
	 */
	public void setQuestionList(Set<SurveyAnswers> questionList) {
		this.questionList = questionList;
	}

	/**
	 * @return the surveySubmitted
	 */
	public Date getSurveySubmitted() {
		return surveySubmitted;
	}

	/**
	 * @param surveySubmitted the surveySubmitted to set
	 */
	public void setSurveySubmitted(Date surveySubmitted) {
		this.surveySubmitted = surveySubmitted;
	}

	public void addQuestion(SurveyAnswers question) {
		if (question != null) {
			if (questionList == null) {
				questionList = new HashSet<>();
			}
			question.setPersistSurveyId(this);
			questionList.add(question);

		}
	}

	@Override
	public String toString() {
		return "SurveyResponse [surveyResponseId=" + surveyResponseId + ", surveyId=" + surveyId + ", deviceId="
				+ deviceId + ", questionList=" + questionList + ", surveySubmitted=" + surveySubmitted + "]";
	}

}
