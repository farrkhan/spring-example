package com.cox.amp.api.reactiveservice;
	
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class UserRepository {
	
	/**
	 * Retrieve user list asynchronously. Simulate delay of a call to a DB
	 */
	public Flux<User> getUsersAsync(int responseDelay) {
		List<User> userList = Arrays.asList(new User[] { 
				new User(1, "user1@example.com", "user1", "1230001"), 
				new User(2, "user2@example.com", "user2", "1230002"), 
				new User(3, "user3@example.com", "user3", "1230003") });
		return Flux.fromIterable(userList).//
				delaySubscription(Duration.ofMillis(responseDelay));
	}
}
