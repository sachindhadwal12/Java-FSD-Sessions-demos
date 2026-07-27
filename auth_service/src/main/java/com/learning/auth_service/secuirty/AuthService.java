package com.learning.auth_service.secuirty;

import com.learning.auth_service.dto.CommonResponse;
import com.learning.auth_service.dto.LoginRequest;
import com.learning.auth_service.dto.RegisterRequest;
import com.learning.auth_service.model.Role;
import com.learning.auth_service.model.User;
import com.learning.auth_service.repository.UserRepository;
import com.learning.auth_service.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
// Register
    public CommonResponse register(RegisterRequest request){

        if (userRepository.existsByUsername(request.getUsername())){
            throw new IllegalArgumentException("Username already exists" + request.getUsername());
        }
        User user =User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole() != null? request.getRole(): Role.ROLE_USER)
                .build();

        userRepository.save(user);
        return new CommonResponse(user.getUsername(),
                null,user.getRole().name(),"Registration successful");

    }

    // Login

    public CommonResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var UserDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(UserDetails);
        String role = UserDetails.getAuthorities()
                .iterator().next().getAuthority();

        return new CommonResponse(null,token, role, "Login successful");
    }







//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


}




