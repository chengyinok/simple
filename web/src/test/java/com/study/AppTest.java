package com.study;

import com.alibaba.fastjson.JSON;
import com.study.redis.RedisUtils;
import com.study.user.entity.User;
import com.study.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {

        // 保存字符串
        redisUtils.set("aaa", "111");

        // 保存对象
        User user = userService.selectById(1);
        redisUtils.set(user.getRealName(), JSON.toJSONString(user));

    }
}
