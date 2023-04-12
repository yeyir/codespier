package com.example.demo.pojo;

import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MethodDetails {
    private String name;
    private Map<String,String> paramMap;
    private String returnType;

}
