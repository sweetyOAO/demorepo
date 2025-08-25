package org.example.backend.service.impl;

import org.example.backend.entity.vo.UserVO;
import org.example.backend.mapper.UserMapper;
import org.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO getOneUser() {
        return userMapper.getOneUser();
    }
}
