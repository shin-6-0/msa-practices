package com.poscodx.emaillist.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.poscodx.emaillist.vo.EmaillistVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/api/emaillist")
public class ApiController {

	private RestTemplate restTemplate;

	public ApiController(@LoadBalanced RestTemplate restTemplate) {
		//Authwired 대신 생성자를 만들어서 때려넣는 방식을 사용!
		this.restTemplate=restTemplate;
	}
	
	
	@GetMapping
	public ResponseEntity<?> read(
			@RequestParam(value="kw", required=true, defaultValue="") String keyword) {
		log.info("Request [GET/api] : "+ keyword);
		
		Map<String,Object> response = restTemplate.getForObject("http://service-emailist/?kw="+keyword, Map.class);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody EmaillistVo vo) {
		log.info("Request [POST/api] : " + vo);
		
		Map<String,Object> response = restTemplate.postForObject("http://service-emailist/",vo,Map.class);	
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
}