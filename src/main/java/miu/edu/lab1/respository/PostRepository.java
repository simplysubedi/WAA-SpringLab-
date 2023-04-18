package miu.edu.lab1.respository;

import miu.edu.lab1.domain.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {

    Post findPostById(int id);

    void deletePostById(int id);

    List<Post> findPostsByAuthor(String author);
    List<Post> findAllByTitle(String title);
}
