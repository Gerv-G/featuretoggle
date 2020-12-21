An exploratory project for learning how to implement annotation-based feature toggles in Spring

# How to use the feature toggle
1. Annotate the endpoint(s) in your controller with `@FeatureToggle` and define a name for it.
Name could be reused so you could mark multiple related endpoints with the same feature name and be toggled at the same time.
    ```java
    @RestController
    public class HelloWorldController {
        @FeatureToggle(name = "hello")
        @GetMapping("/hello")
        public String helloWorld() {
            return "Hello World";
        }
    }
    ```
2. Optional: List and toggle each feature in the `application.yaml`. When set to `true`, the endpoint will be available.
Otherwise, it will return HTTP 404 when called.
    ```yaml
    featuretoggle:
      features:
        hello: true
        # list of other features here    
    ```
   
Note: if the endpoints is annotated with `@FeatureToggle` but is not defined in the `application.yaml`, it will be disabled by default.

# Future plans
- will try to change the `featuretoggle.features` in `application.yaml` into a list instead of a map to make it convenient to add/modify them as environment variables
e.g. as environment variables of a K8s pod, which can be configured without rebuilding the application.
- will convert (or maybe create a new repo) this into a library instead of a Spring application