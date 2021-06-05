package com.youpassed.controller;

import com.youpassed.domain.Exam;
import com.youpassed.domain.User;
import com.youpassed.exception.ExamNotFoundException;
import com.youpassed.exception.UserNotFoundException;
import com.youpassed.service.ExamService;
import com.youpassed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class StudentRestController {
    @Autowired
    public UserService userService;

    @GetMapping
    public ResponseEntity getListStudent(@RequestParam int pageIndex){
        Page<User> users = userService.findAll(pageIndex, 10);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity getStrudent(@PathVariable int studentId){
        try {
            User user = userService.findById(studentId);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
