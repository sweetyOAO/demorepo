package org.example.backend.entity.vo;

import lombok.Data;
import org.example.backend.entity.Users;

@Data
public class UserVO extends Users {
    private String username;
    private String avatarUrl;
    private Boolean isAdmin;
}
