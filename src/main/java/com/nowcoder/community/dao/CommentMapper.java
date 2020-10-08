package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> selectAllComments();

    List<Comment> selectCommentsByEntity(int entityType, int entityId, int offset, int limit);

    int selectCountByEntity(int entityType, int entityId);

    int insertComment(Comment comment);

    Comment selectCommentById(int id);

    List<Comment> selectCommentByUserId(int userId,int offset,int limit);

    int selectCommentCountByUserId(int userId);

    List<Comment> selectReplysByCommentId(int commentId, int offset, int limit);

    List<Comment> selectCommentsWithOrder(int entityType, int entityId, int offset, int limit, int orderMode);

    int updateLikeCountById(int id,int likeCount);

    int updatePostId(int id,int postId);

    int updateStatus(int id,int status);

    int selectCommentCountByPostId(int postId);

    List<Comment> selectNewReply();

}
