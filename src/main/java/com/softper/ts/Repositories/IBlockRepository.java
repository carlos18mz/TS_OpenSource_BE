package com.softper.ts.Repositories;

import com.softper.ts.Model.Block;

import java.util.List;

import com.softper.ts.Model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlockRepository extends JpaRepository<Block, Integer> {
    @Query("select b from Block b where b.user.id = (:uid)")
    List<Block> findBlockedsByUserId(@Param("uid")int userId);

    @Query("select b from Block b where b.user.id = (:uid) and b.blocked.id = (:bid)")
    Block findBlockByUserAndBlockedId(@Param("uid")int userId, @Param("bid")int blockedId);
}
