package com.goks.prototype.biz.position.service.mapper;

import com.goks.prototype.biz.position.domain.Position;
import com.goks.prototype.biz.position.dto.PositionDTO;
import org.mapstruct.*;

/**
 * PackageName    : com.goks.prototype.biz.position.service.mapper
 * Author         : circle
 * Date           : 11/25/24
 * FileName       : IntelliJ IDEA
 * Name           : PositionMapper
 * Description    :
 */
@Mapper(componentModel = "spring")
public interface PositionMapper extends EntityMapper<PositionDTO, Position> {}

