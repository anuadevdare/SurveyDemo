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
	@PostMapping(path = "/savesurvey", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SurveyDto createSurvey(@Valid @RequestBody SurveyDto survey) {
		return surveyService.createSurvey(survey);

	}

	/**
	 * get survey API for the fetch the latest survey for the client
	 */
	@GetMapping(path = "/getsurvey/{clientId}")
	public SurveyDto getSurveyByClientId(@PathVariable long clientId) {

		return surveyService.getSurveyByClientId(clientId);
	}
	@PostMapping(path = "/savesurveyanswrs", consumes = MediaType.APPLICATION_JSON_VALUE)
	public SurveyResponseDto persistSurvey(@Valid @RequestBody SurveyResponseDto surveyAnswers) {
		return persistSurveyService.persistSurvey(surveyAnswers);

	}
}
