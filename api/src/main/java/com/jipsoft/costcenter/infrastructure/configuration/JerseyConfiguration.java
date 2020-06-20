package com.jipsoft.costcenter.infrastructure.configuration;

import com.google.common.reflect.ClassPath;
import com.jipsoft.costcenter.controller.BaseController;
import com.jipsoft.costcenter.infrastructure.exception.GenericExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import java.io.IOException;

@Configuration
@ApplicationPath("/api")
public class JerseyConfiguration extends ResourceConfig {

    @PostConstruct
    public void init() {
        try {
            ClassPath.from(getClassLoader()).getAllClasses()
                    .stream()
                    .filter(classInfo -> classInfo.getPackageName().contains("com.jipsoft."))
                    .filter(classInfo -> isExtendedBaseController(classInfo.load()))
                    .forEach(clazz -> register(clazz.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        register(GenericExceptionMapper.class);
    }

    private boolean isExtendedBaseController(Class<?> clazz) {
        return clazz.getSuperclass() != null && clazz.getSuperclass().equals(BaseController.class);
    }
}
