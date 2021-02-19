package com.autofactory.controller.rest.config;

import com.autofactory.exception.NotFoundExceptionMapper;
import com.autofactory.model.car.detail.transmission.TransmissionType;
import com.autofactory.service.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(CarBodyTypeService.class);
        set.add(CarBodyService.class);
        set.add(CarService.class);
        set.add(EngineTypeService.class);
        set.add(EngineService.class);
        set.add(TransmissionType.class);
        set.add(TransmissionService.class);
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        set.add(new NotFoundExceptionMapper());
        return set;
    }
    
}
