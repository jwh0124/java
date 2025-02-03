package com.goks.prototype.biz.position.service.impl;

import com.goks.prototype.biz.position.domain.Position;
import com.goks.prototype.biz.position.dto.PositionDTO;
import com.goks.prototype.biz.position.repository.PositionRepository;
import com.goks.prototype.biz.position.service.PositionService;
import com.goks.prototype.biz.position.service.mapper.PositionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * PackageName    : com.goks.prototype.biz.position.service.impl
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : PositionServiceImpl
 * Description    :
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {
	private static final Logger LOG = LoggerFactory.getLogger(PositionServiceImpl.class);

	private final PositionRepository positionRepository;

	private final PositionMapper positionMapper;


	public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper) {
		this.positionRepository = positionRepository;
		this.positionMapper = positionMapper;
	}

	@Override
	public PositionDTO save(PositionDTO positionDTO) {
		LOG.debug("Request to save Position : {}", positionDTO);
		Position position = positionMapper.toEntity(positionDTO);
		position = positionRepository.save(position);
		return positionMapper.toDto(position);
	}

	@Override
	public PositionDTO update(PositionDTO positionDTO) {
		LOG.debug("Request to update Position : {}", positionDTO);
		Position position = positionMapper.toEntity(positionDTO);
		position = positionRepository.save(position);
		return positionMapper.toDto(position);
	}

	@Override
	public Optional<PositionDTO> partialUpdate(PositionDTO positionDTO) {
		LOG.debug("Request to partially update Position : {}", positionDTO);

		return positionRepository
				.findById(positionDTO.getId())
				.map(existingPosition -> {
					positionMapper.partialUpdate(existingPosition, positionDTO);

					return existingPosition;
				})
				.map(positionRepository::save)
				.map(positionMapper::toDto);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PositionDTO> findAll(Pageable pageable) {
		LOG.debug("Request to get all Positions");
		return positionRepository.findAll(pageable).map(positionMapper::toDto);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PositionDTO> findOne(Long id) {
		LOG.debug("Request to get Position : {}", id);
		return positionRepository.findById(id).map(positionMapper::toDto);
	}

	@Override
	public void delete(Long id) {
		LOG.debug("Request to delete Position : {}", id);
		positionRepository.deleteById(id);
	}
}
