package edu.circle.prototype.sse.controller;

import ch.qos.logback.core.testUtil.RandomUtil;
import edu.circle.prototype.sse.dto.AccessEventDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Random;
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
@RequestMapping("/api/sse")
public class SseController {

	static SseEmitter emitter = null;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value= "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter streamTime() {
		emitter = new SseEmitter(60*1000L);

		try {
			emitter.send(SseEmitter.event().name("connect").data("Connection established"));
		} catch (IOException e) {
			emitter.completeWithError(e);
		}

		return emitter;
	}
}
