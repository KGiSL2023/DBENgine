package com.kgisl.dbEngine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.dbEngine.entity.EisTrnCoverNote;

@Repository
public interface EisTrnCoverNoteRepo extends JpaRepository<EisTrnCoverNote, Integer> {

}
