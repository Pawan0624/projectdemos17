package com.example.commentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentservice.model.Comments;
import com.example.commentservice.service.CommentService;


@RestController
@RequestMapping("/comments")
public class CommentsController {
	
	
	@Autowired
	CommentService service;
	
	@Value("${server.port}")
	public String port;
	
	@GetMapping("/port")
	public String getPort() {
		return "Application is running on port: "+port;
	}
	
	
	@GetMapping("/showAll")
	public ResponseEntity<List<Comments>> getAllNotes(){
		return new ResponseEntity<>(service.showAllComments(), HttpStatus.OK);
	}

	
	@PostMapping("/add")
	public ResponseEntity<Comments> insertNotes(@RequestBody Comments comment){
		return new ResponseEntity<>(service.addComments(comment), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/search/{cid}")
	public ResponseEntity<Optional<Comments>> searchNotesByCid(@PathVariable("cid") int  cid){
		
		return new ResponseEntity<>(service.searchCommentsByCid(cid), HttpStatus.OK);
	}
	
	@GetMapping("/searchOnPid/{pid}")
	public ResponseEntity<List<Comments>> searchNotesByPid(@PathVariable("pid") int  pid){
		
		return new ResponseEntity<>(service.searchCommentsByPid(pid), HttpStatus.OK);
	}

}
