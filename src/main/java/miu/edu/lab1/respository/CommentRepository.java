package miu.edu.lab1.respository;

import miu.edu.lab1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    //@Query("SELECT c from Comment c join fetch Post p where p.c.id=:id ")
  // List<Comment> findCommentByPostId(int id);

}
