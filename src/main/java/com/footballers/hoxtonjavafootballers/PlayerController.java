package com.footballers.hoxtonjavafootballers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository PlayerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return PlayerRepository.findAll();
    }

    @PostMapping("/players")
    public Player createNewPlayer(@RequestBody Player PlayerData) {
        return PlayerRepository.save(PlayerData);
    }

    @DeleteMapping("/player/{id}")
    public String deletePlayer(@PathVariable Integer id) {
        PlayerRepository.deleteById(id);
        return "PLAYER SUCCESSFULLY DELETED!";
    }

    @PatchMapping("/players/{id}")
    public Player updatePlayer(@RequestBody Player PlayerData, @PathVariable Integer id) {
        PlayerData.id = id;
        return PlayerRepository.save(PlayerData);
    }
}

@Entity
class Player {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    public String nationality;
    public int scoreOutOfTen;
    public boolean isReplacement;
    public int teamId;

    public Player() {
    }
}

interface PlayerRepository extends JpaRepository<Player, Integer> {
}