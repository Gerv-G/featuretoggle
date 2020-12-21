package com.gerv.featureflag.presentation;

import com.gerv.featureflag.core.FeatureToggle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/unannotated")
    public String unannotated() {
        return "Hello World";
    }

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

    @FeatureToggle
    @GetMapping("/disableddefault")
    public String farewellWorld() {
        return "Farewell World";
    }
}
