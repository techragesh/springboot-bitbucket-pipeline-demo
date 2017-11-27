package com.techjava.springbootbitbucketpipelinedemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest")
@Api(value = "This is User service Rest endpoint", description = "Shows the user information")
public class UserController {

    @GetMapping("/users")
    @ApiOperation(value = "getUserList", httpMethod = "GET")
    public List<User> getUserList(){
            return new ArrayList(Arrays.asList(new User("ragesh",10000L), new User("suresh", 20000L)));
    }

    @GetMapping("/getUserbyName/{username}")
    @ApiOperation(value = "getUserbyName Details", httpMethod = "GET")
    public User getUserbyName(@PathVariable String username){
        return new User(username, 10000L);
    }


    @ApiModel(value = "This is the User Model for User Service API", discriminator = "user", subTypes = {User.class})
    public class User {

        @ApiModelProperty(notes = "name of the user")
        private String username;
        @ApiModelProperty(notes = "salary of the user")
        private Long salary;

        public User(String username, Long salary) {
            this.username = username;
            this.salary = salary;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }
    }
}
