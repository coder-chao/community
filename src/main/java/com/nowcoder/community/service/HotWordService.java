package com.nowcoder.community.service;

import com.nowcoder.community.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class HotWordService {

    @Autowired
    private RedisTemplate redisTemplate;


    private String HOTWORD_KEY = RedisKeyUtil.getHotWordKey();

    public List<String> getHotWords() {
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = redisTemplate.opsForZSet().reverseRange(HOTWORD_KEY, 0, 10);
        for (String s : set) {
            list.add(s);
        }
        return list;
    }

    public void increHotWord(String keyWord) {
        if (!redisTemplate.hasKey(HOTWORD_KEY)) {
            redisTemplate.opsForZSet().add(HOTWORD_KEY, keyWord, 1);
            redisTemplate.expire(HOTWORD_KEY, 30, TimeUnit.DAYS);
        } else {
            redisTemplate.opsForZSet().incrementScore(HOTWORD_KEY, keyWord, 1);
        }
    }

}
