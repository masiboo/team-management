package com.example.teammanagement.repository;

import com.example.teammanagement.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TeamRepository extends JpaRepository<Team, Long>, QueryByExampleExecutor<Team> {
}
