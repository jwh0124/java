package com.goks.prototype.biz.position.service;

import com.goks.prototype.biz.position.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * PackageName    : com.goks.prototype.biz.position.service.impl
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : PositionService
 * Description    :
 */
public interface PositionService {
	/**
	 * Save a position.
	 *
	 * @param positionDTO the entity to save.
	 * @return the persisted entity.
	 */
	PositionDTO save(PositionDTO positionDTO);

	/**
	 * Updates a position.
	 *
	 * @param positionDTO the entity to update.
	 * @return the persisted entity.
	 */
	PositionDTO update(PositionDTO positionDTO);

	/**
	 * Partially updates a position.
	 *
	 * @param positionDTO the entity to update partially.
	 * @return the persisted entity.
	 */
	Optional<PositionDTO> partialUpdate(PositionDTO positionDTO);

	/**
	 * Get all the positions.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<PositionDTO> findAll(Pageable pageable);

	/**
	 * Get the "id" position.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<PositionDTO> findOne(Long id);

	/**
	 * Delete the "id" position.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
