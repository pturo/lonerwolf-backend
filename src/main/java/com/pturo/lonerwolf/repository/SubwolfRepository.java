package com.pturo.lonerwolf.repository;

import com.pturo.lonerwolf.model.Subwolf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubwolfRepository extends JpaRepository<Subwolf, Long> {
    Optional<Subwolf> findByName(String subwolfName);
}
