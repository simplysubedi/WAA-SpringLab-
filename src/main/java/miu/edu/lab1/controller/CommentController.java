package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.dto.request.CommentDto;
import miu.edu.lab1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping()
    String addComment(@RequestBody Comment c){
        commentService.addComment(c);
        return "Comment Added";
    }
    @GetMapping
    List<CommentDto> findAllComments(){
       return  commentService.findAllComments();
    }
    @GetMapping("/{id}")
    List<CommentDto>findCommentsByPostId(@PathVariable int id){
        return commentService.findCommentsByPostId(id);
    }
}
