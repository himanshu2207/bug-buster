package com.hijack.service;

import com.hijack.dao.inter.UserDao;
import com.hijack.entity.daoEntity.User;
import com.hijack.models.AuthenticationRequest;
import com.hijack.models.AuthenticationResponse;
import com.hijack.models.RegisterRequest;
import com.hijack.security.JWTHelper;
import com.hijack.utils.constants.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    @Autowired
    UserDao userDao;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JWTHelper jwtHelper;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthenticationResponse registerUser(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.User)
                .build();
        user = userDao.save(user);
        String token = jwtHelper.generateToken(user);
        var authRes = AuthenticationResponse.builder()
                        .token(token)
                        .build();
        return authRes;
    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                request.getPassword()));
        var user = userDao.findByUsername(request.getUsername());
        String token = jwtHelper.generateToken(user);
        var authRes = AuthenticationResponse.builder()
                        .token(token)
                        .build();
        return authRes;
    }
}
