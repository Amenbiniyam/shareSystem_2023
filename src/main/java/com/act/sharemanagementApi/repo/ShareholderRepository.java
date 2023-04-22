package com.act.sharemanagementApi.repo;

import com.act.sharemanagementApi.model.Shareholder;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {
    void deleteById(Long id);
    Optional<Shareholder> findById (Long id);
//    @EntityGraph(attributePaths = "tbl_subscription")
//    List<Shareholder> findAllWithChildren();
//    @Query("SELECT p FROM tbl_shareholders p LEFT JOIN FETCH p.subscriptions c WHERE p.id =  c.id ")
//    Optional<Shareholder> findAllWithChildren();


}
