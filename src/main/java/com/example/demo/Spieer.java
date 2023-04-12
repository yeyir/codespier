package com.example.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.pojo.MethodDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Spieer implements CommandLineRunner, ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> controllers = context.getBeansWithAnnotation(Controller.class);
        for (Map.Entry<String, Object> entry : controllers.entrySet()) {
            System.out.println("拿到bean" + entry.getKey() + "拿到内容" + entry.getValue());
            System.out.println("拿类里的成员");
            Class c = entry.getValue().getClass();
            Field[] declaredFields = c.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println("拿到" + field.getType());
            }
            Method[] declaredMethods = c.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println(getMethodDetails(method).toString());
            }
        }
    }

    public MethodDetails getMethodDetails(Method method) {
        MethodDetails methodDetails = new MethodDetails();
        methodDetails.setName(method.getName());
        methodDetails.setReturnType(method.getReturnType().getName());
        Parameter[] parameters = method.getParameters();
        Map<String, String> m = new HashMap<>();
        for (Parameter parameter : parameters) {
            m.put(parameter.getName(), parameter.getType().getName());
        }
        methodDetails.setParamMap(m);
        return methodDetails;
    }
}
