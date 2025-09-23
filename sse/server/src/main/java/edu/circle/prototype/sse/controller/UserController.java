package edu.circle.prototype.sse.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * PackageName    : edu.circle.prototype.sse.controller
 * Author         : circle
 * Date           : 25. 8. 11.
 * FileName       : IntelliJ IDEA
 * Name           : UserController
 * Description    :
 */
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping
	public ResponseEntity<String> getUserList() throws Exception {
		return ResponseEntity.ok("User ReadAll API");
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<String> getUser(@PathVariable UUID id) throws Exception {
        logger.info(id.toString());
		return ResponseEntity.ok("User Read API");
	}

	@PostMapping
	public ResponseEntity<String> postUser(@RequestBody String body) throws Exception {
        logger.info(body);
        return ResponseEntity.ok("User Create API");
	}

    @PutMapping(path = "{id}")
    public ResponseEntity<String> putUser(@PathVariable UUID id, @RequestBody String body) throws Exception {
        logger.info("ID: {}, Body: {}", id, body);
        return ResponseEntity.ok("User Update API");
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) throws Exception {
        logger.info(id.toString());
        return ResponseEntity.ok("User Delete API");
    }
}
