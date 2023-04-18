package miu.edu.lab1.service;

import miu.edu.lab1.domain.dto.request.LoginRequest;
import miu.edu.lab1.domain.dto.request.RefreshTokenRequest;
import miu.edu.lab1.domain.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
