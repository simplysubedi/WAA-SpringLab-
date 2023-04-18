package miu.edu.lab1.service;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.dto.request.CommentDto;

import java.util.List;

public interface CommentService {
    void addComment(Comment c);

    List<CommentDto> findAllComments();

    List<CommentDto> findCommentsByPostId(int id);
}
