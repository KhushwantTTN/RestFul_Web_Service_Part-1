package com.example.springpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    // URl Versioning //
    @GetMapping("/v1/user")
    public UserV1 userV1(){
        return new UserV1("Khushwant");
    }

    @GetMapping("/v2/user")
    public UserV2 userV2(){
        return new UserV2("Khushwant","Prajapati",23);
    }

    // URL Versioning //


    // Request Param Versioning //
    @GetMapping(path = "/user/request" , params = "version=1")
    public UserV1 userRequestParamV1(){
        return new UserV1("Khushwant");
    }

    @GetMapping(path = "/user/request" , params = "version=2")
    public UserV2 userRequestParamV2(){
        return new UserV2("Khushwant","Prajapati",23);
    }

    // Request Param Versioning //


    // Custom Header Versioning //
    @GetMapping(path = "/user/header" , headers = "version=1")
    public UserV1 userCustomHeaderV1(){
        return new UserV1("Khushwant");
    }

    @GetMapping(path = "/user/header" , headers = "version=2")
    public UserV2 userCustomHeaderV2(){
        return new UserV2("Khushwant","Prajapati",23);
    }

    // Custom Header Versioning //

    // Media type or Mime Type Versioning //
    @GetMapping(path = "/user" , produces = "application/vnd.company.app-v1+json")
    public UserV1 userMimeTypeV1(){
        return new UserV1("Khushwant");
    }

    @GetMapping(path = "/user" , produces = "application/vnd.company.app-v2+json")
    public UserV2 userMimeTypeV2(){
        return new UserV2("Khushwant","Prajapati",23);
    }

    // Media Type or Mime type Versioning //
}
