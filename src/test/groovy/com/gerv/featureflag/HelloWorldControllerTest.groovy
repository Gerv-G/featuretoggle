package com.gerv.featureflag

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@SpringBootTest(
        classes = FeatureflagApplication,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    def "Should return hello world"() {
        when:
            def response = testRestTemplate.getForEntity("/hello", String.class)

        then:
            response.body == "Hello World"
    }
}
