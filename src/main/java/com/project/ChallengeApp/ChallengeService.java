package com.project.ChallengeApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ChallengeService
 */
@Service
public class ChallengeService {
    private List<Challenge> challenges=new ArrayList<>();
    private Long nextId=1L;

    public ChallengeService() {
        Challenge c1=new Challenge(nextId++,"February","CompltetSpringBoot");
        challenges.add(c1);
    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public  boolean addChallenge( Challenge challenge) {
       if(challenge!=null){
        challenge.setId(nextId++);
        challenges.add(challenge);
        return true;
       }
       return false;
    }
    public List<Challenge> getChallenge(String month){
        List<Challenge> challengeList = new ArrayList<>();
        for (Challenge challenge : challenges) {
            if(challenge.getMonth().equalsIgnoreCase(month)){
                challengeList.add(challenge);
            }
        }
        return challengeList;
    }

    public boolean updateChallenge(Long id, Challenge updatedchallenge) {
        for (Challenge challenge : challenges) {
            if(challenge.getId()==id)
                challenge.setMonth(updatedchallenge.getMonth());
                challenge.setDescription(updatedchallenge.getDescription());
                return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        for (Challenge challenge : challenges) {
            if(challenge.getId()==id)
                challenges.remove(challenge);
                return true;
        }
        return false;
    }
}