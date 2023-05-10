package com.kgisl.dbEngine.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kgisl.dbEngine.entity.EisTrnCoverNote;
import com.kgisl.dbEngine.entity.EisTrnCoverNoteExt;
import com.kgisl.dbEngine.entity.QueryParamModel;
import com.kgisl.dbEngine.service.DBEngineService;

@RestController
@RequestMapping(path = "/")
public class DBEngineController {

	@Autowired
	private DBEngineService dbEngineService;
	

	Logger logger = LoggerFactory.getLogger(DBEngineController.class);
	
	@GetMapping("/getAllCoverNoteDetails")
	public List<EisTrnCoverNote> getCoverNoteDetails() {

		List<EisTrnCoverNote> coverNoteDetails = (List<EisTrnCoverNote>) dbEngineService.getAllCoverNote();

		return coverNoteDetails;

	}
	
	@GetMapping("/getAllCoverageDetails")
	public List<EisTrnCoverNoteExt> getCoverageDetails() {

		List<EisTrnCoverNoteExt> coverageDetails = (List<EisTrnCoverNoteExt>) dbEngineService.getAllCoverages();

		return coverageDetails;

	}
	
	@PostMapping("/copyCoverNoteDetails")
	public void copyCoverNoteDetails(@RequestBody QueryParamModel queryParamModel) throws JsonProcessingException {

		List<EisTrnCoverNote> coverNoteDetails = getCoverNoteDetails();
		
		dbEngineService.copyColumnData(queryParamModel, dbEngineService.covertToJson(coverNoteDetails));
	}
	
	@PostMapping("/copyCoverageDetails")
	public void copyCoverageDetails(@RequestBody QueryParamModel queryParamModel) throws JsonProcessingException {

		List<EisTrnCoverNoteExt> coverageDetails = getCoverageDetails();
		dbEngineService.copyColumnData(queryParamModel, dbEngineService.covertToJson(coverageDetails));
	}
	
	@GetMapping("/getColumnDataType")
	public Map<String,String> getDBColumnType(){
		return dbEngineService.getCoumnType("mtallocn","sourcedb");
	}
	
}
