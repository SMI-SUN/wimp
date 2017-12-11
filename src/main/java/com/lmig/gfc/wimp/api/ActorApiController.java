package com.lmig.gfc.wimp.api;

import java.util.ArrayList;
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
import com.lmig.gfc.wimp.models.ActorView;
import com.lmig.gfc.wimp.services.ActorRepository;

@RestController
@RequestMapping("/api/actors")
public class ActorApiController {
	private ActorRepository actorRepository;

	public ActorApiController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;

	}

	@GetMapping("")
	public List<ActorView> getAll() {
		ArrayList<ActorView> actorViews = new ArrayList<ActorView>();
		for (Actor actor : actorRepository.findAll()) {
			actorViews.add(new ActorView(actor));
		}
		return actorViews;

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ActorView create(@RequestBody Actor actor) {
		actorRepository.save(actor);
		ActorView view = new ActorView(actor);
		return view;
	}

	@GetMapping("{id}")
	public ActorView getOne(@PathVariable Long id) {
		Actor actor = actorRepository.findOne(id);
		ActorView view = new ActorView(actor);
		return view;
	}

	@PutMapping("{id}")
	public ActorView update(@RequestBody Actor actor, @PathVariable Long id) {
		actor.setId(id);
		actorRepository.save(actor);
		ActorView view = new ActorView(actor);
		return view;

	}

	@DeleteMapping("{id}")
	public ActorView delete(@PathVariable Long id) {
		// gets actor from db so i can return it later

		Actor actor = actorRepository.findOne(id);
		// delete actor from db, in this case we are setting the value in the array to
		// null
		actorRepository.delete(id);

		// return the view of the actor i just deleted

		ActorView view = new ActorView(actor);
		return view;

	}
}
