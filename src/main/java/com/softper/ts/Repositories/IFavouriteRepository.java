package com.softper.ts.Repositories;

import com.softper.ts.Model.Favourite;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFavouriteRepository extends JpaRepository<Favourite, Integer> {

    @Query("select f from Favourite f where f.user.id = (:uid)")
    List<Favourite> findFavouritesByUserId(@Param("uid") int userId);

    @Query("select f from Favourite f where f.user.id = (:uid) and f.favourited.id = (:fid)")
    Favourite findFavouriteByUserAndFavouriteId(@Param("uid")int userId, @Param("fid")int favouriteId);
}
