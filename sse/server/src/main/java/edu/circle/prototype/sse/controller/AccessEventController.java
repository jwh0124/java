package edu.circle.prototype.sse.controller;

import edu.circle.prototype.sse.domain.AccessEvent;
import edu.circle.prototype.sse.dto.AccessEventDto;
import edu.circle.prototype.sse.service.AccessEventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PackageName    : edu.circle.prototype.sse.controller
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : AccessEventController
 * Description    :
 */
@RestController
@RequestMapping("/api/access-events")
public class AccessEventController {

	private AccessEventService accessEventService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<AccessEventDto> getAccessEventList() throws Exception {

		return accessEventService.findAll()
				.stream()
				.map(accessEvent -> modelMapper.map(accessEvent, AccessEventDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping(path = "{id}")
	public AccessEventDto getAccessEvent(@PathVariable Long id) throws Exception {
		try {
			AccessEvent accessEvent = accessEventService.findById(id);

			return modelMapper.map(accessEvent, AccessEventDto.class);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@PostMapping
	public void postAccessEvent(@RequestBody AccessEventDto accessEventDto) throws Exception {
		var accessEvent = modelMapper.map(accessEventDto, AccessEvent.class);
		accessEventService.save(accessEvent);

		try{
			SseController.emitter.send(SseEmitter.event().name("access").data(accessEvent));
		}catch (IOException e) {
			throw new Exception("Failed to send access event: " + e.getMessage());
		}
	}

	@Autowired
	public void setAccessEventService(AccessEventService accessEventService) {
		this.accessEventService = accessEventService;
	}
}
