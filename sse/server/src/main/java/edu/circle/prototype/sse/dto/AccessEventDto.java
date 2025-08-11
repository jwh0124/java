package edu.circle.prototype.sse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

/**
 * PackageName    : edu.circle.prototype.sse.dto
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEventDto
 * Description    :
 */
@Data
@AllArgsConstructor
public class AccessEventDto {

	private Long id;

	private String name;

	private Instant occurredAt;

}
