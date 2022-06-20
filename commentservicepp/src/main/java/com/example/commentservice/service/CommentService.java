package com.example.commentservice.service;

import java.util.List;
import java.util.Optional;

import com.example.commentservice.model.Comments;


public interface CommentService {
	
	public Comments addComments(Comments comment);
	public List<Comments> showAllComments();
	public List<Comments> searchCommentsByPid(int pid);
	public Optional<Comments> searchCommentsByCid(int cid);


}
