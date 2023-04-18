package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.User;
import miu.edu.lab1.domain.dto.request.PostDto;
import miu.edu.lab1.domain.dto.request.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findUserById(int id);

    void addUser(User user);

    List<PostDto> getAllPostsByUserId(int id);

    List<UserDto> getPostsOfUser(Integer noOfPosts);

    void addPostToUserByUserId(int id, Post post);

    void deleteUser(int id);

    List<UserDto> findUserByPostTitle(String title);
}
