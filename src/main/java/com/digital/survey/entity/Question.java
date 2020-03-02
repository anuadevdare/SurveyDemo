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

/**
 * Entity class for Question
 * 
 * @author Anita Devdare
 * @since 1.0
 */
@Entity
@Table(name = "QUESTION_MASTER")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * questionId id auto-generated primary key of the question_master table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_ID")
	private long questionId;
	/**
	 * surveyid is a foreign key of the survey table
	 */
	@JsonIgnore
	@JoinColumn(name = "SURVEY_ID")
	@ManyToOne
	private Survey surveyId;
	/**
	 * Represents question text for the column
	 */
	@Column(name = "QUESTION_TEXT", nullable = false)
	private String questionText;

	/**
	 * Represents to store answers in the question
	 */
	@Column(name = "TYPE", nullable = false, length = 25)
	private String type;
	@OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL)
	private Set<Answer> answerList;

	/**
	 * 
	 */
	public Question() {
		super();
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
	 * @return the surveyId
	 */
	public Survey getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
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
	public Set<Answer> getAnswerList() {
		return answerList;
	}

	/**
	 * @param answerList the answerList to set
	 */
	public void setAnswerList(Set<Answer> answerList) {
		this.answerList = answerList;
	}

	public void addAnswers(Answer answer) {
		if (answer != null) {
			if (answerList == null) {
				answerList = new HashSet<>();
			}
			answer.setQuestionId(this);
			answerList.add(answer);

		}
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", surveyId=" + surveyId + ", questionText=" + questionText
				+ ", type=" + type + ", answerList=" + answerList + "]";
	}

}
