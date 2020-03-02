package com.digital.survey.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SURVEY_ANSWERS")
public class SurveyAnswers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long surveyQustionId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "SURVEY_RESPONSE_ID")
	private SurveyResponse persistSurveyId;

	@Column(name = "QUSETION_ID", columnDefinition = "BIGINT", length = 20)
	private long questionId;

	
	private long answerId;

	public SurveyAnswers() {
		super();
	}

	/**
	 * @param surveyQustionId
	 * @param persistSurveyId
	 * @param questionId
	 * @param answerId
	 */
	public SurveyAnswers(long surveyQustionId, SurveyResponse persistSurveyId, long questionId, long answerId) {
		super();
		this.surveyQustionId = surveyQustionId;
		this.persistSurveyId = persistSurveyId;
		this.questionId = questionId;
		this.answerId = answerId;
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
	 * @return the persistSurveyId
	 */
	public SurveyResponse getPersistSurveyId() {
		return persistSurveyId;
	}

	/**
	 * @param persistSurveyId the persistSurveyId to set
	 */
	public void setPersistSurveyId(SurveyResponse persistSurveyId) {
		this.persistSurveyId = persistSurveyId;
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

	
	/*
	 * public void addAnswers(SurveyAnswers answer) { if (answer != null) { if
	 * (answerList == null) { answerList = new HashSet<>(); }
	 * answer.setPersistQustionId(this); answerList.add(answer);
	 * 
	 * } }
	 */
	

}
