package com.nowcoder.community;

import com.nowcoder.community.dao.CommentMapper;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.Comment;
import com.nowcoder.community.entity.DiscussPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CommentTest {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void commentUpdate() {
        List<Comment> comments = commentMapper.selectAllComments().stream()
                .filter(item -> item.getEntityType() == 2 && item.getTargetId() == 0).collect(Collectors.toList());
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            Comment first = commentMapper.selectCommentById(comment.getEntityId());
            comment.setPostId(first.getPostId());
            commentMapper.updatePostId(comment.getId(), comment.getPostId());
        }
//        comments.forEach(item->item.setPostId(commentMapper.selectCommentById(item.getEntityId()).getPostId()));

    }

    @Test
    public void commentUpdate1() {
        List<Comment> comments = commentMapper.selectAllComments().stream()
                .filter(item -> item.getEntityType() == 2 && item.getTargetId() != 0).collect(Collectors.toList());
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            Comment first = commentMapper.selectCommentById(comment.getEntityId());
            comment.setPostId(first.getPostId());
            commentMapper.updatePostId(comment.getId(), comment.getPostId());
        }
//        comments.forEach(item->item.setPostId(commentMapper.selectCommentById(item.getEntityId()).getPostId()));

    }

    @Test
    public void commentUpdate2() {
        List<Comment> comments = commentMapper.selectAllComments();
        for (Comment comment : comments) {
            int postId = comment.getPostId();
            DiscussPost post = discussPostMapper.selectDiscussPostById(postId);
            if (post == null || post.getStatus() == 2) {
                comment.setStatus(2);
            }
        }
    }
}
