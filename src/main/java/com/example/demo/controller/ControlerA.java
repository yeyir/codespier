package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.ATMapper;

@RestController
public class ControlerA {
    @Autowired
    ATMapper mapper;

    @GetMapping("/a")
    public String geString() {
        Map bl = new HashMap<String, Object>();
        List b = new ArrayList<String>();
        b.add("2");
        bl.put("bl", b);
        System.out.println(mapper.geString(bl));
        return "asasa";
    }
}
