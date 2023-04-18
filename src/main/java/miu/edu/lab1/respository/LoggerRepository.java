package miu.edu.lab1.respository;

import miu.edu.lab1.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger,Integer> {
}
