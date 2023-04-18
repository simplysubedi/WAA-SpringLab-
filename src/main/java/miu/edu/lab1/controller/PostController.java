package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.dto.request.PostDto;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> findAll(@RequestParam(required = false) String title) {
        if (title == null) {
            return postService.findAll();
        } else {
            return postService.findPostByTitle(title);
        }
    }

    @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable int id) {
        return postService.findPostById(id);

    }

    @PostMapping
    public String addPost(@RequestBody Post p) {
        postService.addPost(p);
        return "Post Added";
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable int id) {
        postService.deletePostById(id);
    }

    @PutMapping("/{id}")
    public String updatePostById(@PathVariable int id, @RequestBody Post p) {
        postService.updatePostById(id, p);
        return "Post Updated";
    }

    @GetMapping("/search")
    public List<Post> findPostsByAuthor(@RequestParam String author) {
        return postService.findPostsByAuthor(author);
    }

    @PostMapping("/comments/{id}")
    String addCommentToPostbyPostId(@PathVariable int id, @RequestBody Comment comment) {
        postService.addCommentToPostbyPostId(id, comment);
        return "Post updated";
    }
}
