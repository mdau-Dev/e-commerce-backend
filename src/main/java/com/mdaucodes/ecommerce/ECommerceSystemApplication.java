package com.mdaucodes.ecommerce;

import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceSystemApplication.class, args);



//        ObjectMapper mapper=new ObjectMapper();
//        mapper.getFactory().setStreamWriteConstraints(
//                StreamWriteConstraints.builder().maxNestingDepth(3000).build()
//        );
    }

}
