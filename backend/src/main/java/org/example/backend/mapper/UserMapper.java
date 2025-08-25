package org.example.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.entity.vo.UserVO;

@Mapper
public interface UserMapper {
    UserVO getOneUser();
}
