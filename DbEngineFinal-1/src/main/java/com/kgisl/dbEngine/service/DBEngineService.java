package com.kgisl.dbEngine.service;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kgisl.dbEngine.entity.EisTrnCoverNote;
import com.kgisl.dbEngine.entity.EisTrnCoverNoteExt;
import com.kgisl.dbEngine.entity.QueryParamModel;

public interface DBEngineService {
	List<EisTrnCoverNote> getAllCoverNote();

	void copyColumnData(QueryParamModel queryParamModel, JSONArray jsonArray) throws JsonProcessingException;

	List<EisTrnCoverNoteExt> getAllCoverages();

	JSONArray covertToJson(List<?> entityObj) throws JsonProcessingException;

	Map<String, String> getCoumnType(String string, String string2);
}
