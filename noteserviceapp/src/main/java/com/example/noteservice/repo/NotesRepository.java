package com.example.noteservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.noteservice.model.Notes;


@Repository
public interface NotesRepository extends JpaRepository<Notes,Integer> {

	
	
}
