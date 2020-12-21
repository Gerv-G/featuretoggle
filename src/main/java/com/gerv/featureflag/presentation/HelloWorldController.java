package com.gerv.featureflag.presentation;

import com.gerv.featureflag.core.FeatureToggle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @FeatureToggle(name = "hello")
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @FeatureToggle(name = "goodbye")
    @GetMapping("/goodbye")
    public String goodbyeWorld() {
        return "Goodbye World";
    }
}
