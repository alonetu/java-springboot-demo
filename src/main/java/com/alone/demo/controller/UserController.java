package com.alone.demo.controller;

import com.alone.demo.common.Result;
import com.alone.demo.entity.User;
import com.alone.demo.mapper.UserMapper;
import com.alone.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// 给接口加上统一前缀
@RequestMapping("/user")
public class UserController {

    // 注入其他类的一个注解
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public Result findAll() {
        List<User> all = userMapper.findAll();
        return Result.success(all);
    }

    // 分页查询
    // 路径 /user/page?pageNum=1&pageSize=10
    // RequestParam 接收
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();

        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    @PostMapping
    public Integer save(@RequestBody User user) {
        // 新增或者修改
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}
