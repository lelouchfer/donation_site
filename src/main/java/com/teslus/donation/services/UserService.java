package com.teslus.donation.services;


import com.teslus.donation.commons.GenericService;
import com.teslus.donation.entities.User;
import com.teslus.donation.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends GenericService<User,Integer>, UserDetailsService {
    User findByEmail(String email);
    Map save(UserRegistrationDto usuarioRegistroDto);
}
