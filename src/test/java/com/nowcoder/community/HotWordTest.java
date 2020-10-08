package com.nowcoder.community;

import com.nowcoder.community.service.HotWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class HotWordTest {

    @Autowired
    private HotWordService hotWordService;

    @Test
    public void HotWord(){
        List<String> hotWords = hotWordService.getHotWords();
        System.out.println("----------------------");
        hotWords.forEach(System.out::println);
        System.out.println("----------------------");
    }

}
