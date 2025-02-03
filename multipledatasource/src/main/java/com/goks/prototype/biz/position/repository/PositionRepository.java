package com.goks.prototype.biz.position.repository;

import com.goks.prototype.biz.position.domain.Position;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * PackageName    : com.goks.prototype.biz.position.repository
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : PositionRepository
 * Description    :
 */
@SuppressWarnings("unused")
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {}
