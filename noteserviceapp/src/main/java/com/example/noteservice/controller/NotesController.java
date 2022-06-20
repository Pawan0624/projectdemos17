package com.example.noteservice.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	NoteService service;
	
	
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
	
	public ResponseEntity<List<CommentsDto>> findCommentsForPid(@PathVariable("pid") int pid){
		
		return new ResponseEntity<>(service.findCommentsForPid(pid), HttpStatus.OK);
	
	}
	
}
