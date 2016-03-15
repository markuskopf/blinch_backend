package com.blinch.server.service.account;

import com.blinch.server.domain.customer.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by markuskopf on 14/03/16.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO user = userService.findByEmailAddress(email);

        if (user == null) {
            throw  new UsernameNotFoundException(String.format("User with email=%s was not found", email));
        }

        String password_hash = new BCryptPasswordEncoder().encode("12345678");
        user.setPasswordHash(password_hash);

        return new CurrentUser(user);
    }
}
