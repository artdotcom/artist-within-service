/**
 * 
 */
package com.art.service.artist_within;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.art.service.artist_within.Application;

/**
 * @author achaturvedi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ApplicationIT {
	@Autowired
	protected MockMvc mvc;

	protected static HttpHeaders testHttpHeaders;

	@BeforeClass
	public static void setup() {
		testHttpHeaders = new HttpHeaders();
		testHttpHeaders.add("Accept", "application/json");
	}

	@Test
	public void testManageHealthURL() throws UnsupportedEncodingException, Exception {
		String response = mvc
				.perform(get("/manage/health").contentType(MediaType.APPLICATION_JSON).headers(testHttpHeaders))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.status", equalTo("UP"))).andReturn().getResponse().getContentAsString();

		assertNotEquals(StringUtils.EMPTY, response);
	}

}
