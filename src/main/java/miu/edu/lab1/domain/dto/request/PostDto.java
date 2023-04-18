package miu.edu.lab1.domain.dto.request;

import lombok.Data;
import miu.edu.lab1.domain.Comment;

import java.util.List;

@Data
public class PostDto {
    long id;
    String title;

    String author;
    List<Comment> comments;
}
