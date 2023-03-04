package com.exercise.security.token;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableScheduling
@Log4j2
public class ScheduledTokenService {

	private final TokenService tokenService;

	@Scheduled(cron = "0 10 2 * * ?")
	public void removeExpiredToken() {
		try {
			log.info("Started");
			tokenService.removeOldTokens();
			log.info("Finished");
		} catch (Exception e) {
			log.error(String.format("Remove expired token", e.getMessage()), e);
		}
	}

}
