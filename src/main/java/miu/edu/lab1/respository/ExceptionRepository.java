package miu.edu.lab1.respository;
import miu.edu.lab1.domain.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends JpaRepository<ExceptionLog,Integer> {
}
