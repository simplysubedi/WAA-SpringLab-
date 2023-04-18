package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.Comment;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.dto.request.PostDto;
import miu.edu.lab1.respository.PostRepository;
import miu.edu.lab1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<PostDto> findAll() {
        return getDtos((List<Post>) postRepository.findAll());
    }

    List<PostDto> getDtos(List<Post> posts) {
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(p -> postDtos.add(modelMapper.map(p, PostDto.class)));
        return postDtos;
    }

    @Override
    public PostDto findPostById(int id) {
        return modelMapper.map(postRepository.findPostById(id), PostDto.class);

    }

    public void addPost(Post p) {
        postRepository.save(p);
    }

    @Override
    public void deletePostById(int id) {
        postRepository.deletePostById(id);
    }

    @Override
    public void updatePostById(int id, Post p) {
        p.setId(id);
        postRepository.save(p);
    }

    @Override
    public List<Post> findPostsByAuthor(String author) {
        return postRepository.findPostsByAuthor(author);
    }

    @Override
    public void addCommentToPostbyPostId(int id, Comment comment) {
        Post post=postRepository.findPostById(id);
        List<Comment> commentList=post.getComments();
        commentList.add(comment);
        post.setComments(commentList);
        postRepository.save(post);
    }

    @Override
    public List<PostDto> findPostByTitle(String title) {
        List<Post> posts=postRepository.findAllByTitle(title);
        return getDtos(postRepository.findAllByTitle(title));
    }

}
