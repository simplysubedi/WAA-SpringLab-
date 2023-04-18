package miu.edu.lab1.service.impl;

import jakarta.transaction.Transactional;
import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.User;
import miu.edu.lab1.domain.dto.request.PostDto;
import miu.edu.lab1.domain.dto.request.UserDto;

import miu.edu.lab1.respository.UserRepository;
import miu.edu.lab1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
      return getUserDto(userRepository.findAll());
    }

    @Override
    public UserDto findUserById(int id) {
        return modelMapper.map(userRepository.findById(id),UserDto.class);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<PostDto> getAllPostsByUserId(int id) {
        User user=userRepository.findById(id).get();
        return user.getPosts().stream().map(x->modelMapper.map(x,PostDto.class)).toList();
    }

    @Override
    public List<UserDto> getPostsOfUser(Integer noOfPosts) {
        List<User> users= userRepository.findUserByPostsGreaterThan(noOfPosts);
        return getUserDto(users);
    }

    @Override
    public void addPostToUserByUserId(int id, Post post) {
        User user=userRepository.findById(id).get();
        List<Post> postList=user.getPosts();
        postList.add(post);
        user.setPosts(postList);
        userRepository.save((user));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findUserByPostTitle(String title) {
        return getUserDto(userRepository.findUserByPostTitle(title));
    }


    private List<UserDto> getUserDto(Iterable<User> user) {
        List<UserDto> userDtos = new ArrayList<>();
        user.forEach(p -> userDtos.add(modelMapper.map(p, UserDto.class)));
        return userDtos;
    }


}
