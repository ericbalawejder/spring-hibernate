package com.json.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(
                new File("src/main/resources/com/json/jackson/demo/data/sample-full.json"), Student.class);

        Address address = student.getAddress();

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(address.getStreet());
        System.out.println(address.getCity());
        System.out.println(Arrays.toString(student.getLanguages()));
    }
}
