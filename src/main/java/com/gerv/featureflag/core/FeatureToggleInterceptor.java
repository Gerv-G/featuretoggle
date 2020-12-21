package com.gerv.featureflag.core;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class FeatureToggleInterceptor implements HandlerInterceptor {

    private final Map<String, Boolean> toggleableFeatures;

    public FeatureToggleInterceptor(FeatureToggleConfig featureToggleConfig) {
        this.toggleableFeatures = featureToggleConfig.getFeatures();
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        FeatureToggle featureToggle = handlerMethod.getMethodAnnotation(FeatureToggle.class);

        if (featureToggle == null) {
            return true;
        }

        boolean isEnabled = toggleableFeatures.getOrDefault(featureToggle.name(), false);

        if(!isEnabled) {
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return isEnabled;
    }
}

