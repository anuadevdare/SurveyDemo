package com.digital.survey;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JunitInput implements Serializable {
    
    private final static long serialVersionUID = 1L;

    @JsonProperty("requestMethod")
    private String requestMethod;
    @JsonProperty("expectedStatus")
    private Integer expectedStatus;
    @JsonProperty("expectedResponseBody")
    private Object expectedResponseBody;
    @JsonProperty("requestEndpoint")
    private String requestEndpoint;
    @JsonProperty("contentType")
    private String contentType;
    
    public String getRequestMethod() {
        return requestMethod;
    }
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
    public Integer getExpectedStatus() {
        return expectedStatus;
    }
    public void setExpectedStatus(Integer expectedStatus) {
        this.expectedStatus = expectedStatus;
    }
    public Object getExpectedResponseBody() {
        return expectedResponseBody;
    }
    public void setExpectedResponseBody(Object expectedResponseBody) {
        this.expectedResponseBody = expectedResponseBody;
    }
    public String getRequestEndpoint() {
        return requestEndpoint;
    }
    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
}
