package com.example.demo.pojo;

import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClassDetails {
    private String name;
    private Map<String,String> fieldMap;
    private Map methodMap;
}
