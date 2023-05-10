package com.kgisl.dbEngine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.dbEngine.entity.EisTrnCoverNoteExt;

@Repository
public interface EisTrnCoverNoteExtRepo extends JpaRepository<EisTrnCoverNoteExt, Integer>{

}
