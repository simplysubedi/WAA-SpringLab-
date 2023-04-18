package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.dto.request.CommentDto;
import miu.edu.lab1.respository.CommentRepository;
import miu.edu.lab1.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addComment(Comment c) {
        commentRepository.save(c);
    }

    @Override
    public List<CommentDto> findAllComments() {
        return getCommentDto(commentRepository.findAll());
    }

    @Override
    public List<CommentDto> findCommentsByPostId(int id) {
       // return getCommentDto(commentRepository.findCommentByPostId(id));
        return null;
    }

    List<CommentDto> getCommentDto(List<Comment> comments) {
        List<CommentDto> commentsDto = new ArrayList<>();
        comments.forEach(c -> commentsDto.add(modelMapper.map(c, CommentDto.class)));
        return commentsDto;
    }
}
