package com.example.noteservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteservice.model.CommentsDto;
import com.example.noteservice.model.Notes;
import com.example.noteservice.service.NoteService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/notes")
public class NotesController {
	
	Logger logger = LoggerFactory.getLogger(NotesController.class);
	
	@Autowired
	NoteService service;
	
	@GetMapping("/commentsport")
	public String getCommentsAppPort() {
		return service.getCommentServicePort();
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Notes>> getAllNotes(){
		return new ResponseEntity<>(service.showAllNotes(), HttpStatus.OK);
	}

	
	@PostMapping("/add")
	public ResponseEntity<Notes> insertNotes(@RequestBody Notes note){
		return new ResponseEntity<>(service.addNotes(note), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/search/{pid}")
	public ResponseEntity<Optional<Notes>> searchNotesByPid(@PathVariable("pid") int  pid){
		
		return new ResponseEntity<>(service.searchNotesByPid(pid), HttpStatus.OK);
	}
	
	@GetMapping("/comments/{pid}")
	//@Retry(name = "comment-api", fallbackMethod="sendDummyComments")
	
	//@CircuitBreaker(name = "comment-api", fallbackMethod="sendDummyComments")
	@RateLimiter(name="default", fallbackMethod="sendDummyComments")
	//@Retry(name="comments", fallbackMethod="sendDummyComments")
	public List<CommentsDto> findCommentsForPid(@PathVariable("pid") int pid){
		
		logger.info("tried to connect to comment service");
		return service.findCommentsForPid(pid);
	
	}
	
	public List<CommentsDto> sendDummyComments(Exception e){
		List<CommentsDto> data = new ArrayList<>();
		data.add(new CommentsDto(5001,2001,"temp1","dummy comment1"));
		data.add(new CommentsDto(5002,2002,"temp2","dummy comment2"));
		data.add(new CommentsDto(5003,2001,"temp3","dummy comment3"));
		data.add(new CommentsDto(5004,2003,"temp4","dummy comment4"));
		return data;
	}
}
