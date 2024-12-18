package com.app.playerservicejava.service;

import com.app.playerservicejava.exception.PlayerNotFoundException;
import com.app.playerservicejava.model.Player;
import com.app.playerservicejava.model.Players;
import com.app.playerservicejava.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    private PlayerRepository playerRepository;

    public Players getPlayers() {
        Players players = new Players();
        playerRepository.findAll()
                .forEach(players.getPlayers()::add);
        return players;
    }

    public Optional<Player> getPlayerById(String playerId) {
        Optional<Player> player;

        /* simulated network delay */
        try {
            player = playerRepository.findById(playerId);
            Thread.sleep((long)(Math.random() * 2000));
        } catch (Exception e) {
            LOGGER.error("message=Exception in getPlayerById; exception={}", e.toString());
            return Optional.empty();
        }
        return player;
    }

    public Player savePlayer(Player player){
        try{
            return  playerRepository.save(player);
        }catch (Exception e){
            LOGGER.error("Couldn't save player: ", e);
            throw e;
        }

    }
    public Player updatePlayer(String playerId, Player playerDetails) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            Player existingPlayer = player.get();
            existingPlayer.setFirstName(playerDetails.getFirstName());
            existingPlayer.setLastName(playerDetails.getLastName());
            // Update other fields as necessary
            return playerRepository.save(existingPlayer);
        } else {
            throw new PlayerNotFoundException("Player not found with id: " + playerId);
        }
    }
    public void deletePlayer(String playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            playerRepository.delete(player.get());
        } else {
            throw new PlayerNotFoundException("Player not found with id: " + playerId);
        }
    }

}
