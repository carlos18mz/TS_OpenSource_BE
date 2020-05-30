package com.softper.ts.Repositories;

import com.softper.ts.Model.Subscription;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Integer> {
    @Query("select s from Subscription s where s.user.id = (:uid)")
    List<Subscription> getSubscriptionsByUserId(@Param("uid") Integer userId);
}
