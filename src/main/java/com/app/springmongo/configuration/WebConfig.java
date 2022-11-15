package com.app.springmongo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("images", registry);
        registry.addResourceHandler(
                        "/resources/**",
//                        "/static/**",
                        "/webjars/**",
                        "/images/**",
                        "/css/**",
                        "/js/**")
                .addResourceLocations(
                        "/resources/",
//                        "/app/src/main/resources/static/images/",
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/images/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path staticPath = Paths.get("src/main/resources/static");
        Path uploadDir = staticPath.resolve(Paths.get(dirName));

        String uploadPath = uploadDir.toFile().getAbsolutePath();
        System.out.println("Upload Path" + " " + uploadPath);
        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");

        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");

    }
}
