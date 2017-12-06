package com.lmig.gfc.wimp.api;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;

import com.lmig.gfc.wimp.services.ActorRepository;

 

@RestController
@RequestMapping("/api/actors")
public class ActorApiController {
	private ActorRepository actorRepository;
	
	
	
	public ActorApiController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
		
	}
		
	@GetMapping("")
	public List<Actor> getAll() {		
		
		return actorRepository.findAll();
		
		}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@RequestBody Actor actor) {
		return actorRepository.save(actor);
		
		
		
	}
	
	@GetMapping("{id}")
	 public Actor getOne(@PathVariable Long id) {
		return actorRepository.findOne(id);
		
	}
	
	@PutMapping("{id}")
	 public Actor update(@RequestBody Actor actor,  @PathVariable Long id) {
		actor.setId(id);;
		return actorRepository.save(actor);
		 
		
	}
	
	@DeleteMapping("{id}")
	 public Actor delete(@PathVariable Long id) {
		// gets actorfrom db so i can return it later
		 
		Actor actor = actorRepository.findOne(id);
		//delete dog from db, in this case we are setting the value in the array to null
		actorRepository.delete(id);
		
		// return the dog i just deleted
		
	  return actor;
		
		
	}
}

