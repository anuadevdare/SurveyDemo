package com.digital.survey;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * DTO for JUNIT test case
 *
 *
 * @author Kunal Gandhre
 * @since 1.1.0.712
 * @Date 15-Sep-2017 7:14:48 PM
 */
/**
 * @author kasaudha
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "restClass", "method", "expectedStatus", "Object", "expectedContentType",
        "requestEndpoint", "contentType", "queryParams", "body", "acceptLanguage", "entityClass",
        "entityData", "entityUnit", "acceptInput", "mockMethods", "enabled" })
public final class JunitInputDto implements Serializable {

    @JsonProperty("restClass")
    private String restClass;
    @JsonProperty("requestMethod")
    private String requestMethod;
    @JsonProperty("expectedStatus")
    private Integer expectedStatus;
    @JsonProperty("expectedResponseBody")
    private Object expectedResponseBody;
    @JsonProperty("expectedContentType")
    private String expectedContentType;
    @JsonProperty("requestEndpoint")
    private String requestEndpoint;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("authToken")
    private String authToken;
    @JsonProperty("queryParams")
    private String queryParams;
    @JsonProperty("body")
    private Object body;
    @JsonProperty("acceptLanguage")
    private String acceptLanguage;
    @JsonProperty("entityClass")
    private String entityClass;
    @JsonProperty("entityData")
    private String entityData;
    @JsonProperty("entityUnit")
    private String entityUnit;
    @JsonProperty("acceptInput")
    private String acceptInput;
    /*
     * @JsonProperty("mockMethods") private List<Object> mockMethods = null;
     * 
     * @JsonProperty("mockRest") private List<MockRestDto> mockRestList = null;
     */
    @JsonProperty("enabled")
    private Boolean enabled;
    private final static long serialVersionUID = 6530337671691812239L;

    /**
     * @return the restClass
     */
    public String getRestClass() {
        return restClass;
    }

    /**
     * @param restClass
     *            the restClass to set
     */
    public void setRestClass(String restClass) {
        this.restClass = restClass;
    }

    /**
     * @return the method
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * @param requestMethod
     *            the requestMethod to set
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * @return the expectedStatus
     */
    public Integer getExpectedStatus() {
        return expectedStatus;
    }

    /**
     * @param expectedStatus
     *            the expectedStatus to set
     */
    public void setExpectedStatus(Integer expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    /**
     * @return the expectedResponseBody
     */
    public Object getExpectedResponseBody() {
        return expectedResponseBody;
    }

    /**
     * @param expectedResponseBody
     *            the expectedResponseBody to set
     */
    public void setExpectedResponseBody(Object expectedResponseBody) {
        this.expectedResponseBody = expectedResponseBody;
    }

    /**
     * @return the expectedContentType
     */
    public String getExpectedContentType() {
        return expectedContentType;
    }

    /**
     * @param expectedContentType
     *            the expectedContentType to set
     */
    public void setExpectedContentType(String expectedContentType) {
        this.expectedContentType = expectedContentType;
    }

    /**
     * @return the requestEndpoint
     */
    public String getRequestEndpoint() {
        return requestEndpoint;
    }

    /**
     * @param requestEndpoint
     *            the requestEndpoint to set
     */
    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }

    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * @param contentType
     *            the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * @return the queryParams
     */
    public String getQueryParams() {
        return queryParams;
    }

    /**
     * @param queryParams
     *            the queryParams to set
     */
    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * @return the body
     */
    public Object getBody() {
        return body;
    }

    /**
     * @param body
     *            the body to set
     */
    public void setBody(Object body) {
        this.body = body;
    }

    /**
     * @return the acceptLanguage
     */
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    /**
     * @param acceptLanguage
     *            the acceptLanguage to set
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    /**
     * @return the entityClass
     */
    public String getEntityClass() {
        return entityClass;
    }

    /**
     * @param entityClass
     *            the entityClass to set
     */
    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * @return the entityData
     */
    public String getEntityData() {
        return entityData;
    }

    /**
     * @param entityData
     *            the entityData to set
     */
    public void setEntityData(String entityData) {
        this.entityData = entityData;
    }

    /**
     * @return the entityUnit
     */
    public String getEntityUnit() {
        return entityUnit;
    }

    /**
     * @param entityUnit
     *            the entityUnit to set
     */
    public void setEntityUnit(String entityUnit) {
        this.entityUnit = entityUnit;
    }

    /**
     * @return the acceptInput
     */
    public String getAcceptInput() {
        return acceptInput;
    }

    /**
     * @param acceptInput
     *            the acceptInput to set
     */
    public void setAcceptInput(String acceptInput) {
        this.acceptInput = acceptInput;
    }

    /*    *//**
             * @return the mockMethods
             */
    /*
     * public List<Object> getMockMethods() { return mockMethods; }
     * 
     *//**
        * @param mockMethods
        *            the mockMethods to set
        */
    /*
     * public void setMockMethods(List<Object> mockMethods) { this.mockMethods =
     * mockMethods; }
     * 
     *//**
        * @return the mockRestList
        */
    /*
     * public List<MockRestDto> getMockRestList() { return mockRestList; }
     * 
     *//**
        * @param mockRestList
        *            the mockRestList to set
        *//*
           * public void setMockRestList(List<MockRestDto> mockRestList) {
           * this.mockRestList = mockRestList; }
           */

    /**
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the authToken
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

}
