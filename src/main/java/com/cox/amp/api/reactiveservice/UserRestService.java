package com.cox.amp.api.reactiveservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

/**
 * REST service with methods to fetch users synchronously or asynchrounously (reactive).
 */
@RestController
@RequestMapping("/user")
public class UserRestService {
	@Autowired
	UserRepository repository;

	

	@GetMapping("/async")
	public Flux<User> asyncList(@RequestParam(defaultValue="500", value = "delay", required = false) int delay) {
		return repository.getUsersAsync(delay);
	}

}
