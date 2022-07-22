package com.example.GateWay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wel")
public class Test {

@GetMapping
public String getMsg()
{
	return "hello msg";
}
}
