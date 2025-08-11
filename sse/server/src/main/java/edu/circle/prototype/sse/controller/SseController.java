package edu.circle.prototype.sse.controller;

import edu.circle.prototype.sse.dto.AccessEventDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * PackageName    : edu.circle.prototype.sse.controller
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : SseController
 * Description    :
 */
@RestController
public class SseController {

	@GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter streamTime() {
		SseEmitter emitter = new SseEmitter();

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			try {
				AccessEventDto dto = new AccessEventDto(1L,"Test Event", Instant.now());
				emitter.send(dto, MediaType.APPLICATION_JSON);
				emitter.complete();
			} catch (IOException e) {
				emitter.completeWithError(e);
			}
		});
		executor.shutdown();

		return emitter;
	}
}
