package com.digital.survey;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(Parameterized.class)
@SpringBootTest
@ActiveProfiles("test")
class DigitalSurveyDemoApplicationTests {
	private static final String JSON_FILES = "classpath*:junits/test/*.json";

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@ClassRule
	public static final SpringClassRule classRule = new SpringClassRule();

	@Rule
	public final SpringMethodRule methodRule = new SpringMethodRule();

	@Autowired
	private WebApplicationContext appContext;

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.appContext).build();
	}

	@Parameter(value = 0)
	public JunitInput junitInput;

	@Test
	void contextLoads() {
	}

	@Parameterized.Parameters(name = "{index}: {0}")
	public static Collection<Object[]> collectData() throws JsonParseException, JsonMappingException, IOException {

		Collection<Object[]> params = new ArrayList<>();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		Resource[] t = resolver.getResources(JSON_FILES);
		ArrayList<JunitInput> list = new ArrayList<>();

		for (int i = 0; i < t.length; i++) {
			list = MAPPER.readValue(t[i].getInputStream(),
					MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, JunitInput.class));

			list.forEach((e) -> {
				params.add(new Object[] { e });
			});
		}
		return params;
	}

	@Test
	public void testRestAPI() throws Exception {
		HttpMethod requestMethod = HttpMethod.valueOf(junitInput.getRequestMethod());
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.request(requestMethod,
				junitInput.getRequestEndpoint());
		requestBuilder.accept(junitInput.getContentType());
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);

		resultActions.andDo(print()).andExpect(MockMvcResultMatchers.status().is(junitInput.getExpectedStatus()));

		if (junitInput.getExpectedResponseBody() != null) {
			resultActions.andExpect(MockMvcResultMatchers.content()
					.json(MAPPER.writeValueAsString(junitInput.getExpectedResponseBody()), false));
		}
	}

}
