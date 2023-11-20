package com.fruit.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruit.main.config.JwtProvider;
import com.fruit.main.exception.UserException;
import com.fruit.main.modal.User;
import com.fruit.main.repository.UserRepository;
import com.fruit.main.request.LoginRequest;
import com.fruit.main.response.AuthResponse;
import com.fruit.main.service.CustomUserServiceImplementation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private CustomUserServiceImplementation customUserService;

	public AuthController(UserRepository userRepository, 
			JwtProvider jwtProvider,
			CustomUserServiceImplementation customUserService,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
		this.customUserService = customUserService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/singup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
		String email = user.getEmail();
		String password = user.getPassword();
		String name = user.getName();

		User isEmailExist = userRepository.findByEmail(email);

		if (isEmailExist != null) {
			throw new UserException("Email is Already Used With Another Account");
		}

		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setName(name);

		User savedUser = userRepository.save(createdUser);

		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
				savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMsg("Singup Successfully");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	};

	@PostMapping("/singin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest){
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		
		Authentication authentication = authenticate(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMsg("Singin Successfully");
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);	
	}

	private Authentication authenticate(String username, String password) {
		
		UserDetails userDetails = customUserService.loadUserByUsername(username);
		
		if (userDetails == null) {
			throw new BadCredentialsException("Invalid Username");
		}
		
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password....");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
	}
	}
	
