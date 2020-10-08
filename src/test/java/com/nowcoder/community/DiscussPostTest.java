package com.nowcoder.community;

import com.nowcoder.community.dao.CommentMapper;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.Comment;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Event;
import com.nowcoder.community.event.EventProducer;
import com.nowcoder.community.util.CommunityConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class DiscussPostTest implements CommunityConstant {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private CommentMapper commentMapper;


    @Test
    public void postInsert(){

        DiscussPost post = new DiscussPost();
        post.setContentText("虎扑9月30日讯&nbsp;今日小组赛最终分组已经出炉，SN战队所在的A组还有G2&nbsp;&nbsp;MCX&nbsp;TL，SN官推更新动态，Twitter译文（大意）如下：“欢迎G2&nbsp;&nbsp;MCX&nbsp;TL来到A组。”来源：Twitter");
        post.setContent("<div><p></p><p><span id=\"img-wrapper-embedded-0\"></span></p><div><br><img src=\"https://i1.hoopchina.com.cn/blogfile/20209/30/BbsImg_16044655909034_1601467246_s_317979_o_w_800_h_267_91060.png?x-oss-process=image/resize,w_800\" alt=\"\" id=\"thread-img-0\"></div><p></p><p></p></div><div>虎扑9月30日讯&nbsp;今日小组赛最终分组已经出炉，SN战队所在的A组还有G2&nbsp;&nbsp;MCX&nbsp;TL，SN官推更新动态，Twitter译文（大意）如下：</div><p><br></p><div>“欢迎G2&nbsp;&nbsp;MCX&nbsp;TL来到A组。”</div><div><p></p><p><span id=\"img-wrapper-embedded-1\"></span></p><div><img src=\"https://i3.hoopchina.com.cn/blogfile/20209/30/BbsImg_16044655909034_1601467316_s_589876_o_w_826_h_909_16693.png?x-oss-process=image/resize,w_800\" alt=\"\" id=\"thread-img-1\"></div><p></p><p></p></div><div><p></p><p><span id=\"img-wrapper-embedded-2\"></span></p><div><img src=\"https://i4.hoopchina.com.cn/blogfile/20209/30/BbsImg_16044655909034_1601467377_s_723420_o_w_674_h_1024_16632.png?x-oss-process=image/resize,w_800\" alt=\"\" id=\"thread-img-2\"></div><p></p><p></p></div><div><p></p><p><span id=\"img-wrapper-embedded-3\"></span></p><div><img src=\"https://i1.hoopchina.com.cn/blogfile/20209/30/BbsImg_16044655909034_1601467384_s_671802_o_w_654_h_1024_84627.png?x-oss-process=image/resize,w_800\" alt=\"\" id=\"thread-img-3\"></div><p></p><p></p></div><div><p></p><p><span id=\"img-wrapper-embedded-4\"></span></p><div><img src=\"https://i3.hoopchina.com.cn/blogfile/20209/30/BbsImg_16044655909034_1601467451_s_758826_o_w_616_h_1024_49408.png?x-oss-process=image/resize,w_800\" alt=\"\" id=\"thread-img-4\"></div><p></p><p></p></div><div><p></p><p><span id=\"img-wrapper-embedded-5\"></span></p><div><img src=\"https://i4.hoopchina.com.cn/blogfile/20209/30/BbsImg_16044655909034_1601467455_s_593391_o_w_600_h_1024_30888.png?x-oss-process=image/resize,w_800\" alt=\"\" id=\"thread-img-5\"></div><p></p><p></p></div><div>来源：<a href=\"https://twitter.com/suning_gaming/status/1311273937838338048?s=21\" target=\"_blank\">Twitter</a></div>");
        post.setUserId(11);
        post.setCreateTime(new Date());
        post.setTitle("SN官推：欢迎你们来到A组");
        post.setCommentCount(0);
        post.setScore(1750);
        post.setStatus(0);
        post.setType(0);
        post.setLikeCount(0);
        discussPostMapper.insertDiscussPost(post);

        // 触发发帖事件
        Event event = new Event()
                .setTopic(TOPIC_PUBLISH)
                .setUserId(11)
                .setEntityType(ENTITY_TYPE_POST)
                .setEntityId(post.getId());
        eventProducer.fireEvent(event);


    }

    @Test
    public void postImgUrc(){
        String data = discussPostMapper.selectDiscussPostById(334).getContent();
//        String data = "<img src=\"https://pic3.zhimg.com/v2-caebe48a652e4396664142b56307504a_400x224.jpeg\" alt=\"图片\">";
        Pattern pattern = Pattern.compile("src=\\\"?(.*?)(\\\"|>|\\\\s+)");
        Matcher matcher = pattern.matcher(data);

        System.out.println("----------------------");
        System.out.println(matcher.find() ? matcher.group(1):"没找到");
        System.out.println("----------------------");
    }

    @Test
    public void postCommentCount(){
        List<DiscussPost> posts = discussPostMapper.selectAllDiscussPosts();
        for (DiscussPost post : posts){
            int count = commentMapper.selectCommentCountByPostId(post.getId());
            discussPostMapper.updateCommentCount(post.getId(),count);
        }
    }

    @Test
    public void postNewReply(){
//        List<Integer> postIds = commentMapper.selectNewReplyPostIds(0,10);
//        ArrayList<DiscussPost> list = new ArrayList<>();
//        postIds.stream().forEach(i->posts.add(discussPostMapper.selectDiscussPostById(i)));
//        posts.stream().forEach(i-> System.out.println(i.toString()));
//        for (int i = 0; i < postIds.size(); i++) {
//            DiscussPost post = discussPostMapper.selectDiscussPostById(postIds.get(i));
//            list.add(post);
//
//        }
//        System.out.println("-------------------------------------");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
//        System.out.println("-------------------------------------");
    }

    @Test
    public void postNewReply1(){
        List<DiscussPost> posts = discussPostMapper.selectAllDiscussPosts();
      posts.stream().forEach(post->{
          post.setLastCommentTime(post.getCreateTime());
          discussPostMapper.updateDiscussPost(post);
      });
        List<Comment> comments = commentMapper.selectNewReply();
        comments.stream().forEach(comment -> {
            int postId = comment.getPostId();
            DiscussPost post = discussPostMapper.selectDiscussPostById(postId);
            if (post != null){
                post.setLastCommentTime(comment.getCreateTime());
                discussPostMapper.updateDiscussPost(post);
            }
        });
    }

    @Test
    public void postNewReply2(){
        List<DiscussPost> posts = discussPostMapper.selectDiscussPosts(0, 0, 10, 2);
        posts.stream().forEach(i-> System.out.println(i.toString()));
    }
}
