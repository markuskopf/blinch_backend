package com.blinch.server.service.account;

import com.blinch.server.domain.customer.UserDTO;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by markuskopf on 14/03/16.
 */
public class CurrentUser extends User {

    private UserDTO user;

    // String username, String password, Collection<? extends GrantedAuthority> authorities)
    public CurrentUser(UserDTO userDTO) {
        super(userDTO.getEmailAddress(), userDTO.getPasswordHash(), AuthorityUtils.createAuthorityList("Admin"));
//        this.user = userDTO;
    }

//    public User getUser() {
//        return this;
//    }
//
//    public String getId() {
//        return user.getId();
//    }

}
