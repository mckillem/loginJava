package com.exercise.security.token;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

	private final TokenRepository tokenRepository;

	public void saveToken(String token) {
		tokenRepository.save(Token.builder().token(token).build());
	}

	public void deleteToken(String token) {
		tokenRepository.delete(Token.builder().token(token).build());
	}

	public boolean isTokenExisting(String token) {
		return tokenRepository.findAll().stream()
				.anyMatch(t -> t.getToken().equals(token));
	}
}
