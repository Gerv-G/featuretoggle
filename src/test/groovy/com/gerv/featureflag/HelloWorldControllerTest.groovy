package com.gerv.featureflag

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import spock.lang.Specification

@SpringBootTest(
        classes = FeatureflagApplication,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest extends Specification {

    @Autowired
    TestRestTemplate testRestTemplate

    def "Unannotated endpoint should return expected response"() {
        when:
            def response = testRestTemplate.getForEntity("/unannotated", String.class)

        then:
            response.body == "Hello World"
    }

    def "Enabled toggleable feature should return expected response"() {
        when:
            def response = testRestTemplate.getForEntity("/hello", String.class)

        then:
            response.body == "Hello World"
    }

    def "Disabled toggleable feature should return HTTP 404"() {
        when:
            def response = testRestTemplate.getForEntity("/goodbye", String.class)

        then:
            response.statusCode == HttpStatus.NOT_FOUND
    }

    def "Toggleable feature with no name should return HTTP 404"() {
        when:
            def response = testRestTemplate.getForEntity("/disableddefault", String.class)

        then:
            response.statusCode == HttpStatus.NOT_FOUND
    }
}
