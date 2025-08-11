package edu.circle.prototype.sse.repository;

import edu.circle.prototype.sse.domain.AccessEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PackageName    : edu.circle.prototype.sse.repository
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEventRepository
 * Description    :
 */
@Repository
public interface AccessEventRepository extends JpaRepository<AccessEvent, Long> {
}
