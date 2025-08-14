package edu.circle.prototype.sse.service.impl;

import edu.circle.prototype.sse.domain.AccessEvent;
import edu.circle.prototype.sse.repository.AccessEventRepository;
import edu.circle.prototype.sse.service.AccessEventService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PackageName    : edu.circle.prototype.sse.service.impl
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEventServiceImpl
 * Description    :
 */
@Service
public class AccessEventServiceImpl implements AccessEventService {

	private static final Logger LOG = LoggerFactory.getLogger(AccessEventServiceImpl.class);

	private AccessEventRepository accessEventRepository;

	public AccessEventServiceImpl(AccessEventRepository accessEventRepository) {
		this.accessEventRepository = accessEventRepository;
	}

	@Override
	public List<AccessEvent> findAll() {
		return accessEventRepository.findAll();
	}

	@Override
	public AccessEvent findById(Long id) {
		LOG.debug("Request to get AccessEvent by id: {}", id);

		return accessEventRepository.findById(id).orElse(null);
	}

	@Override
	public AccessEvent save(AccessEvent accessEvent) {
		LOG.debug("Request to save AccessEvent: {}", accessEvent);

		return accessEventRepository.save(accessEvent);
	}

	@Autowired
	public void setAccessEventRepository(AccessEventRepository accessEventRepository) {
		this.accessEventRepository = accessEventRepository;
	}
}
