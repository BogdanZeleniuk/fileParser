package com.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static com.TestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-mvc.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"jpa", "postgres"})
public class FileUploadRepositoryImplTest {

    @Autowired
    FileUploadService service;

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
    public void testSave() throws Exception {
        service.save(FILE1);
        service.save(FILE2);
        service.save(FILE3);
        service.save(FILE4);
        service.save(FILE5);
        service.save(FILE6);
        Assert.assertEquals(TEST_DB,service.getAll());
    }

    @Test
    public void testSaveEmptyField() throws Exception {
        thrown.expect(NullPointerException.class);
        service.save(null);
    }
}