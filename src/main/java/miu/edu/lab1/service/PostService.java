package miu.edu.lab1.service;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.dto.request.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findPostById(int id);

    void addPost(Post p);

    void deletePostById(int id);

    void updatePostById(int id, Post p);

    List<Post> findPostsByAuthor(String author);

    void addCommentToPostbyPostId(int id, Comment comment);

    List<PostDto> findPostByTitle(String title);
}
