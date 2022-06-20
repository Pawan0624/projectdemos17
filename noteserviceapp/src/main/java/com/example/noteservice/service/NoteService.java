package com.example.noteservice.service;

import java.util.List;
import java.util.Optional;

import com.example.noteservice.model.CommentsDto;
import com.example.noteservice.model.Notes;

public interface NoteService {
	
	
	public Notes addNotes(Notes Note);
	public List<Notes> showAllNotes();
	public Optional<Notes> searchNotesByPid(int pid);
	
	public List<CommentsDto> findCommentsForPid(int pid);

}
