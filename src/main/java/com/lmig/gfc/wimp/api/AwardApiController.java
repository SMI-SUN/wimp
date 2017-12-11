package com.lmig.gfc.wimp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardApiController {

	private AwardRepository awardRepository;
	private ActorRepository actorRepository;

	public AwardApiController(AwardRepository awardRepository, ActorRepository actorRepository) {

		this.awardRepository = awardRepository;
		this.actorRepository = actorRepository;

	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Actor create(@PathVariable Long actorId, @RequestBody Award award) {

		// Get the actor from the database using an ActorRepository
		Actor actor = actorRepository.findOne(actorId);

		// set the actor on the award using award.setActor()

		if (!actor.getAwards().contains(award)) {
			actor.getAwards().add(award);
			award.setActor(actor);
			awardRepository.save(award);
		}
		return actor;

	}

}
