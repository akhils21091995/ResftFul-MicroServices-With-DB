package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Post;
import com.example.services.PostsService;

@RestController
public class PostsController {

	@Autowired
	private PostsService ps;
	
	
	@RequestMapping("/posts")
	public List<Post>getPosts(){
		return ps.getPosts();
	}
	
	@RequestMapping("/posts/{id}")
	public Post getPost(@PathVariable int id)
	{
		return ps.getPost(id) ;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/posts")
	public void addPost(@RequestBody Post listElement)
	{
		ps.addPost(listElement);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/posts/{id}")
    public void updatePost(@RequestBody Post post)
	{
		ps.updatePost(post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/posts/{id}")
    public void deletePost(@PathVariable int id)
	{
		ps.deletePost(id);
	}
}
