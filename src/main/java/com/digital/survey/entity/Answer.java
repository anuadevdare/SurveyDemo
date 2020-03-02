package com.digital.survey.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class for Answer
 * @since 1.0
 */
@Entity
@Table(name = "ANSWER_MASTER")
public class Answer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * This maps to auto-generated primary key of the answer_master table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ANSWER_ID")
	private long answerId;
	/**
	 * Represents ansId foreign key of the question
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	private Question questionId;
	/**
	 * Represents answerText key of the question
	 */
	@Column(name = "ANSWER_TEXT",nullable = false)
	private String answerText;

	public Answer() {
		super();
	}

	/**
	 * @param answerId
	 * @param questionId
	 * @param answerText
	 */
	public Answer(long answerId, Question questionId, String answerText) {
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

	/**
	 * @return answer object to String
	 */
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", questionId=" + questionId + ", answerText=" + answerText + "]";
	}

}
