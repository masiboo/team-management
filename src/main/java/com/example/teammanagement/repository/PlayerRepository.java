package com.example.teammanagement.repository;

import com.example.teammanagement.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PlayerRepository extends JpaRepository<Player, Long>, QueryByExampleExecutor<Player> {

}
