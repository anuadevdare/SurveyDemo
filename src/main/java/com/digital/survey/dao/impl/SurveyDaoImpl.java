package com.digital.survey.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.survey.dao.DtoEntityConverter;
import com.digital.survey.dao.SurveyDao;
import com.digital.survey.dto.AnswerDto;
import com.digital.survey.dto.QuestionDto;
import com.digital.survey.dto.SurveyDto;
import com.digital.survey.entity.Answer;
import com.digital.survey.entity.Question;
import com.digital.survey.entity.Survey;
import com.digital.survey.repository.SurveyRepository;

@Service
public class SurveyDaoImpl implements SurveyDao, DtoEntityConverter<SurveyDto, Survey> {
	@Autowired
	SurveyRepository repo;
	@Autowired
	QuestionDaoImpl queDaoImpl;
	@Autowired
	AnswerDaoImpl ansDaoImpl;;
	@Autowired
	AnswerDto answerDto;

	boolean status = true;

	@Override
	public void dtoToEntityConvert(SurveyDto dto, Survey entity) {

		entity.setClientId(dto.getClientId());
		entity.setSurveyId(dto.getSurveyId());
		entity.setSurveyTitle(dto.getSurveyTitle());
		Set<Question> question = new HashSet<Question>();
		Set<QuestionDto> questionDto = dto.getQuestionList();
		for (QuestionDto que : questionDto) {
			Question quesEntity = new Question();
			queDaoImpl.dtoToEntityConvert(que, quesEntity);
			question.add(quesEntity);
		}

		entity.setQuestionList(question);

	}

	@Override
	public void entityToDtoConvert(SurveyDto dto, Survey entity) {

		dto.setSurveyId(entity.getSurveyId());
		dto.setSurveyTitle(entity.getSurveyTitle());
		dto.setClientId(entity.getClientId());
		Set<QuestionDto> questions = new HashSet<QuestionDto>();
		for (Question que : entity.getQuestionList()) {
			QuestionDto questionDto = new QuestionDto();
			queDaoImpl.entityToDtoConvert(questionDto, que);
			questions.add(questionDto);
		}
		dto.setQuestionList(questions);

	}

	/**
	 * This method will update last survey status as inactive and create new for the
	 * client
	 * 
	 * @param survey survey object return survey the created survey
	 */
	@Override
	public SurveyDto createSurvey(SurveyDto surveyDto) {
		Survey survey = new Survey();
		dtoToEntityConvert(surveyDto, survey);
		updateStatus(survey, false);
		Set<Question> questionSet = survey.getQuestionList();
		for (Question question : questionSet) {
			survey.addQuestion(question);
			Set<Answer> ansewrSet = question.getAnswerList();
			for (Answer answer : ansewrSet) {
				question.addAnswers(answer);
			}
		}
		survey.setActive(true);
		survey.setSurveyCreated(new Date());
		Survey createdSurvey = repo.save(survey);

		if (createdSurvey == null) {
			updateStatus(survey, true);

		}
		entityToDtoConvert(surveyDto, createdSurvey);
		return surveyDto;
	}

	/**
	 * This method will fetch latest active survey for the client
	 * 
	 * @param clientId long client id
	 * @return survey the latest survey
	 */
	@Override
	public SurveyDto getSurveyByClientId(long clientId) {
		Survey survey = repo.findByclientIdActiveStatus(clientId, true);
		SurveyDto surveyDto = new SurveyDto();
		entityToDtoConvert(surveyDto, survey);
		return surveyDto;
	}

	private void updateStatus(Survey survey, boolean isActive) {

		Survey surveyCurrent = repo.findByclientIdActiveStatus(survey.getClientId(), true);
		if (surveyCurrent != null) {
			surveyCurrent.setActive(isActive);

			repo.save(surveyCurrent);
		}
	}

}
