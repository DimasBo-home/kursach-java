package com.youpassed.controller;
import com.youpassed.domain.Exam;
import com.youpassed.domain.User;
import com.youpassed.exception.ExamNotFoundException;
import com.youpassed.service.ExamService;
import com.youpassed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/exam")
public class ExamRestController {
    @Autowired
    public ExamService examService;
    @GetMapping
    public ResponseEntity getListExamp(){
        List<Exam> exams = examService.findAll();
        return ResponseEntity.ok(exams);
    }
    @GetMapping("/{examId}")
    public ResponseEntity getExam(@PathVariable int examId){
        try {
            Exam exam = examService.findById(examId);
            return ResponseEntity.ok(exam);
        } catch (ExamNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
