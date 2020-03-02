package com.digital.survey.contoller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digital.survey.dto.SurveyDto;
import com.digital.survey.dto.SurveyResponseDto;
import com.digital.survey.service.SurveyReponseService;
import com.digital.survey.service.SurveyService;

/**
 * Rest Controller for the create,update and fetch survey
 * 
 * @author Anita Devdare
 * @since 1.0
 */
@RestController
public class DigitalSurveyController {
	@Autowired
	SurveyService surveyService;
	@Autowired
	SurveyReponseService persistSurveyService;

	/**
	 * create survey API for the client and deactivate the last survey
	 * 
	 */
	@PostMapping(path = "/createsurvey", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SurveyDto createSurvey(@Valid @RequestBody SurveyDto survey) {
		return surveyService.createSurvey(survey);

	}

	/**
	 * The API responsible for the fetch the latest survey for the given client
	 */
	@GetMapping(path = "/getsurvey/{clientId}")
	public SurveyDto getSurveyByClientId(@PathVariable long clientId) {

		return surveyService.getSurveyByActiveClientId(clientId);
	}

	/**
	 * The API is responsible to save the survey response for multiple questions and
	 * their selected possible answers for the given device id.
	 */
	@PostMapping(path = "/savesurveyanswers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveSurveyResponse(@Valid @RequestBody SurveyResponseDto surveyAnswers) {
		persistSurveyService.saveSurveyResponse(surveyAnswers);

	}
}
