package com.footballers.hoxtonjavafootballers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    private TeamRepository TeamRepository;

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return TeamRepository.findAll();
    }

    @PatchMapping("/team/{id}")
    public Team updateTeam(@RequestBody Team TeamData, @PathVariable Integer id) {
        TeamData.id = id;
        return TeamRepository.save(TeamData);
    }
}

@Entity
class Team {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    public Team() {
    }
}

interface TeamRepository extends JpaRepository<Team, Integer> {
}