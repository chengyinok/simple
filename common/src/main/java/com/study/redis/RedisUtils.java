package com.study.redis;

import com.study.aspect.WebLogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    private static final Logger logger =  LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object obj) {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        if (!this.stringRedisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key,obj);
            logger.info("set key success");
        } else {
            // 存在则打印之前的value值
            logger.info("this key = " + ops.get(key));
        }
    }

    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        this.stringRedisTemplate.delete(key);
    }
}
