package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.User;
import miu.edu.lab1.domain.dto.request.PostDto;
import miu.edu.lab1.domain.dto.request.UserDto;
import miu.edu.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> findAll(@RequestParam(required = false) Integer noOfPosts, @RequestParam(required = false) String title) {
        if (noOfPosts == null && title == null) {
            return userService.findAll();
        } else if (noOfPosts == null && title != null) {
            return userService.findUserByPostTitle(title);
        } else return userService.getPostsOfUser(noOfPosts);

    }
    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User Added";
    }
    @GetMapping("/{id}/posts")
    List<PostDto> getAllPostByUserId(@PathVariable int id) {
        return userService.getAllPostsByUserId(id);
    }

    @PostMapping("/posts/{id}")
    String addPostToUserByUserId(@PathVariable int id, @RequestBody Post post) {
        userService.addPostToUserByUserId(id, post);
        return "Post updated";
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted";
    }
    @GetMapping("/getException")
    String getException()throws Exception{
        throw new Exception("Exception found");
    }
}
