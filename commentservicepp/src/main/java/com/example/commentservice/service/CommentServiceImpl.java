package com.example.commentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commentservice.model.Comments;
import com.example.commentservice.repo.CommentsRepository;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentsRepository repo;

	@Override
	public Comments addComments(Comments comment) {
		// TODO Auto-generated method stub
		return repo.save(comment);
	}

	@Override
	public List<Comments> showAllComments() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Comments> searchCommentsByPid(int pid) {
		// TODO Auto-generated method stub
		return repo.findAllCommentsByPid(pid);
	}

	@Override
	public Optional<Comments> searchCommentsByCid(int cid) {
		// TODO Auto-generated method stub
		return repo.findById(cid);
	}

}
