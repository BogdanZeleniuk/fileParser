package com.controller.multiUpload;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"jpa", "postgres"})
public class MultiUploadControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public Stopwatch stopwatch = new Stopwatch() {
        private void logInfo(Description description, long nanos) {
            log.info(String.format("+++ Test %s spent %d microseconds",
                    description.getMethodName(), TimeUnit.NANOSECONDS.toMicros(nanos)));
        }

        @Override
        protected void finished(long nanos, Description description) {
            logInfo(description, nanos);
        }
    };

    @Test
    public void shouldSaveUploadedFile() throws Exception {
        MockMultipartFile multipartFileOne =
                new MockMultipartFile("file", "forTesting.txt", "text/plain", "forTesting".getBytes());
        MockMultipartFile multipartFileTwo =
                new MockMultipartFile("file", "forTestingNext.txt", "text/plain", "forTestingNext".getBytes());
        MockMultipartFile multipartFileThree =
                new MockMultipartFile("file", "forTestingOneMore.txt", "text/plain", "forTestingOneMore".getBytes());

            mockMvc = MockMvcBuilders
                    .webAppContextSetup(webApplicationContext)
                    .build();
            mockMvc.perform(fileUpload("/")
                    .file(multipartFileOne)
                    .file(multipartFileTwo)
                    .file(multipartFileThree))
                    .andExpect(status().is(200))
                    .andExpect(header().string("Location", "/"));
    }


}