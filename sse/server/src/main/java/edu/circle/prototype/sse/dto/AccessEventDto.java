package edu.circle.prototype.sse.dto;

import lombok.*;

import java.time.Instant;

/**
 * PackageName    : edu.circle.prototype.sse.dto
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEventDto
 * Description    :
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccessEventDto {

	private Long id;

	private String name;

	private Instant occurredAt = Instant.now();
}
