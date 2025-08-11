package edu.circle.prototype.sse.service;

import edu.circle.prototype.sse.domain.AccessEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * PackageName    : edu.circle.prototype.sse.service
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEventService
 * Description    :
 */
public interface AccessEventService {

	AccessEvent save(AccessEvent accessEvent);

	AccessEvent findById(Long id);

	List<AccessEvent> findAll();
}
