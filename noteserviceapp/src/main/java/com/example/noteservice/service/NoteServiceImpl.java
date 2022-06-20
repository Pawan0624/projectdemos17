package com.example.noteservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.noteservice.model.CommentsDto;
import com.example.noteservice.model.Notes;
import com.example.noteservice.repo.NotesRepository;


@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	NoteProxyService proxy;
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	NotesRepository repo;

	@Override
	public Notes addNotes(Notes note) {
		// TODO Auto-generated method stub
		return repo.save(note);
	}

	@Override
	public List<Notes> showAllNotes() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Notes> searchNotesByPid(int pid) {
		// TODO Auto-generated method stub
		return repo.findById(pid);
	}

	@Override
	public List<CommentsDto> findCommentsForPid(int pid) {
		// TODO Auto-generated method stub
		//List<CommentsDto> data = template.getForObject("http://localhost:8082/comments/searchOnPid/"+pid,List.class);
		
		List<CommentsDto> data = (List<CommentsDto>) proxy.searchNotesByPid(pid);
		
		return data;
	}

}
