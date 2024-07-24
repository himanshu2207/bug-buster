package com.hijack.models;

import com.hijack.utils.constants.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;

}
