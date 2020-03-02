package com.digital.survey.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.digital.survey.entity.Survey;

/**
 * This is the DAO(Data Access Object) layer interface for Survey
 * 
 * @author Anita Devdare
 * @since 1.0
 */
public interface SurveyRepository extends CrudRepository<Survey, Long> {
	/**
	 * Returns Active survey list by clientID
	 * 
	 * @param clientId client id for fetching the client survey,status for fetching
	 *                 active survey
	 * 
	 * @return the active survey as per client ID
	 */
	@Query("from Survey where clientId=:cId and active=:active")
	Survey findByclientIdActiveStatus(@Param("cId") long cId, @Param("active") boolean active);

}
