package edu.circle.prototype.sse.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 * PackageName    : edu.circle.prototype.sse.domain
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEvent
 * Description    :
 */
@Entity
@Table(name = "access_event")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessEvent {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private Instant occurredAt;
}
