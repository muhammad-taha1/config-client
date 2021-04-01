package com.taha.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RefreshScope
public class AppController {

    @Value("${capitalFeature.enabled}")
    private boolean isCapitalFeatureEnabled;

    @GetMapping("/getName")
    public String getName(@RequestParam String name) {
        if (isCapitalFeatureEnabled) {
            return name.toUpperCase();
        }
        return name;
    }
}
