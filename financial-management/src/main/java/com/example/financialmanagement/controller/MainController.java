package com.example.financialmanagement.controller;

import com.example.financialmanagement.model.BasicRecord;
import com.example.financialmanagement.model.BasicRecordRepository;
import com.example.financialmanagement.service.MainService;
import com.example.financialmanagement.service.RecordService;
import com.example.financialmanagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainController {

    @Resource
    private UserService userService;

    @Resource
    private RecordService recordService;

    @Resource
    private MainService mainService;


    @ResponseBody
    @RequestMapping("/loginError")
    public String loginError() {
        return "Password is wrong! Please login again!";
    }
}