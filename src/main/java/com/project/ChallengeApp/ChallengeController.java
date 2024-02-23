package com.project.ChallengeApp;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ChallengeController
 */
@RestController
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge) {
        challengeService.addChallenge(challenge);
        return "Challenge added successfully";
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<List<Challenge>> getChallenge(@PathVariable String month) {
        List<Challenge> challengeList = challengeService.getChallenge(month);
        if (challengeList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(challengeList, HttpStatus.OK);
    }
    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isChallengeUpdated=challengeService.updateChallenge(id,updatedChallenge);
        if(isChallengeUpdated)
            return new ResponseEntity<>("Challenge Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Challenge Updated Successfully",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted=challengeService.deleteChallenge(id);
        if(isChallengeDeleted)
            return new ResponseEntity<>("Challenge Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Challenge Updated Successfully",HttpStatus.NOT_FOUND);
    }
    

}