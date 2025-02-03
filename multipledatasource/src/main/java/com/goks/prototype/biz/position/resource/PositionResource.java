package com.goks.prototype.biz.position.resource;

import com.goks.prototype.biz.position.dto.PositionDTO;
import com.goks.prototype.biz.position.repository.PositionRepository;
import com.goks.prototype.biz.position.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * PackageName    : com.goks.prototype.biz.position.resource
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : PositionResource
 * Description    :
 */
@RestController
@RequestMapping("/api/positions")
public class PositionResource {
	private static final Logger LOG = LoggerFactory.getLogger(PositionResource.class);

	private static final String ENTITY_NAME = "commonApplicationPosition";

	private final PositionService positionService;

	private final PositionRepository positionRepository;

	public PositionResource(PositionService positionService, PositionRepository positionRepository) {
		this.positionService = positionService;
		this.positionRepository = positionRepository;
	}

	/**
	 * {@code POST  /positions} : Create a new position.
	 *
	 * @param positionDTO the positionDTO to create.
	 * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new positionDTO, or with status {@code 400 (Bad Request)} if the position has already an ID.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PostMapping("")
	public ResponseEntity<PositionDTO> createPosition(@RequestBody PositionDTO positionDTO) throws URISyntaxException {
		LOG.debug("REST request to save Position : {}", positionDTO);

		positionDTO = positionService.save(positionDTO);
		return ResponseEntity.created(new URI("/api/positions/" + positionDTO.getId()))
				.body(positionDTO);
	}

	/**
	 * {@code PUT  /positions/:id} : Updates an existing position.
	 *
	 * @param id the id of the positionDTO to save.
	 * @param positionDTO the positionDTO to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated positionDTO,
	 * or with status {@code 400 (Bad Request)} if the positionDTO is not valid,
	 * or with status {@code 500 (Internal Server Error)} if the positionDTO couldn't be updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PositionDTO> updatePosition(
			@PathVariable(value = "id", required = false) final Long id,
			@RequestBody PositionDTO positionDTO
	) throws URISyntaxException {
		LOG.debug("REST request to update Position : {}, {}", id, positionDTO);

		positionDTO = positionService.update(positionDTO);
		return ResponseEntity.ok()
				.body(positionDTO);
	}

	/**
	 * {@code PATCH  /positions/:id} : Partial updates given fields of an existing position, field will ignore if it is null
	 *
	 * @param id the id of the positionDTO to save.
	 * @param positionDTO the positionDTO to update.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated positionDTO,
	 * or with status {@code 400 (Bad Request)} if the positionDTO is not valid,
	 * or with status {@code 404 (Not Found)} if the positionDTO is not found,
	 * or with status {@code 500 (Internal Server Error)} if the positionDTO couldn't be updated.
	 * @throws URISyntaxException if the Location URI syntax is incorrect.
	 */
	@PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
	public ResponseEntity<PositionDTO> partialUpdatePosition(
			@PathVariable(value = "id", required = false) final Long id,
			@RequestBody PositionDTO positionDTO
	) throws URISyntaxException {
		LOG.debug("REST request to partial update Position partially : {}, {}", id, positionDTO);

		Optional<PositionDTO> result = positionService.partialUpdate(positionDTO);

		return ResponseEntity.ok().body(result.get());
	}

	/**
	 * {@code GET  /positions} : get all the positions.
	 *
	 * @param pageable the pagination information.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of positions in body.
	 */
	@GetMapping("")
	public ResponseEntity<List<PositionDTO>> getAllPositions(Pageable pageable) {
		LOG.debug("REST request to get a page of Positions");
		Page<PositionDTO> page = positionService.findAll(pageable);
		return ResponseEntity.ok().body(page.getContent());
	}

	/**
	 * {@code GET  /positions/:id} : get the "id" position.
	 *
	 * @param id the id of the positionDTO to retrieve.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the positionDTO, or with status {@code 404 (Not Found)}.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PositionDTO> getPosition(@PathVariable("id") Long id) {
		LOG.debug("REST request to get Position : {}", id);
		Optional<PositionDTO> positionDTO = positionService.findOne(id);
		return ResponseEntity.ok().body(positionDTO.get());
	}

	/**
	 * {@code DELETE  /positions/:id} : delete the "id" position.
	 *
	 * @param id the id of the positionDTO to delete.
	 * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePosition(@PathVariable("id") Long id) {
		LOG.debug("REST request to delete Position : {}", id);
		positionService.delete(id);
		return ResponseEntity.noContent()
				.build();
	}
}
