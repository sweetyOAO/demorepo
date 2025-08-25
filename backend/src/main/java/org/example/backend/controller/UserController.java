package org.example.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.entity.vo.UserVO;
import org.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/getusers")
    public List<UserVO> getUsers() {
        System.out.println("调用getusers");
        log.info("调用getusers");
        List<UserVO> list = new ArrayList<>();

        UserVO u1 = new UserVO();
        u1.setId(String.valueOf(UUID.randomUUID()));
        u1.setEmail("alice@example.com");
        u1.setUsername("Alice");
        u1.setIsAdmin(true);
        u1.setCreatedAt(OffsetDateTime.now().minusDays(10));

        UserVO u2 = new UserVO();
        u2.setId(String.valueOf(UUID.randomUUID()));
        u2.setEmail("bob@example.com");
        u2.setUsername("Bob");
        u2.setIsAdmin(false);
        u2.setCreatedAt(OffsetDateTime.now().minusDays(5));

        UserVO u3 = new UserVO();
        u3.setId(String.valueOf(UUID.randomUUID()));
        u3.setEmail("charlie@example.com");
        u3.setUsername("Charlie");
        u3.setIsAdmin(false);
        u3.setCreatedAt(OffsetDateTime.now().minusDays(2));

        UserVO u4 = new UserVO();
        u4 = userService.getOneUser();

        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);

        return list;
    }
}
