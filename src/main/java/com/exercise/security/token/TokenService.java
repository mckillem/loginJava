package com.exercise.security.token;

import com.exercise.security.config.JwtService;
import com.exercise.security.token.model.Token;
import com.exercise.security.token.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TokenService {

	private final TokenRepository tokenRepository;

	private final JwtService jwtService;

	public void saveToken(String token) {
		tokenRepository.save(Token.builder().token(token).build());
	}

	public boolean isTokenExisting(String token) {
		return tokenRepository.findAll().stream()
				.anyMatch(t -> t.getToken().equals(token));
	}

	public void logout(String token) {
		Optional<Token> foundToken = tokenRepository.findById(token);
		if (!foundToken.isPresent()) {
			throw new RuntimeException(String.format("Token does not exist."));
		}

		tokenRepository.delete(foundToken.get());
	}

	public void removeOldTokens() {
		Collection<Token> tokens = tokenRepository.findAll();

		if (tokens.isEmpty()) {
			return;
		}

		Collection<Token> expiredTokens = tokens.stream()
				.filter(t -> jwtService.isTokenExpired(t.getToken()))
				.collect(Collectors.toList());

		if (expiredTokens.isEmpty()) {
			return;
		}

		tokenRepository.deleteAllInBatch(expiredTokens);
	}
}
