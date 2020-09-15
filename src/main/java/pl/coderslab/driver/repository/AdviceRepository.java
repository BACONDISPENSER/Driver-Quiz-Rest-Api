package pl.coderslab.driver.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.driver.entity.Advice;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

    @Query("SELECT a FROM Advice a ORDER BY ?1")
    List<Advice> sortedAdvices(String name);



    List<Advice> findAllByCreatedGreaterThanEqualOrderByLikesDesc(LocalDateTime dateTime);

    @Query(value = "SELECT * FROM portfoliolab.advice ORDER BY portfoliolab.advice.created DESC ", nativeQuery = true)
    List<Advice> adviceListSortedByCreatedDesc();

    @Query(value = "SELECT * FROM portfoliolab.advice ORDER BY portfoliolab.advice.created ASC ", nativeQuery = true)
    List<Advice> adviceListSortedByCreatedAsc();

    @Query(value = "SELECT * FROM portfoliolab.advice ORDER BY portfoliolab.advice.likes DESC ", nativeQuery = true)
    List<Advice> adviceListSortedByLikesDesc();

    @Query(value = "SELECT * FROM portfoliolab.advice ORDER BY portfoliolab.advice.likes ASC ", nativeQuery = true)
    List<Advice> adviceListSortedByLikesAsc();
}