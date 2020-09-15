package pl.coderslab.driver.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.driver.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {



}
