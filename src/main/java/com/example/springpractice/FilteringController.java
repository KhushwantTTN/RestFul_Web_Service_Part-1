package com.example.springpractice;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {


    @GetMapping("/filtering")
    public MappingJacksonValue staticFilterings(){
        Filtering list = new Filtering("Khushwant","235643227347");

        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept("userName"));
        jacksonValue.setFilters(filters);

        return jacksonValue;
    }
}
