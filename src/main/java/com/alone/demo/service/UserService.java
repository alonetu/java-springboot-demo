package com.alone.demo.service;

import com.alone.demo.entity.User;
import com.alone.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 将service注入到springboot容器中去
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        // user没有id表示新增
        if (user.getId() == null) {
            return userMapper.insert(user);
        } else { // 否则就是更新
            return userMapper.update(user);
        }
    }
}
