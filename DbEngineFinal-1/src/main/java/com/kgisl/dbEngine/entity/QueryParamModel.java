package com.kgisl.dbEngine.entity;

import java.util.HashMap;
import java.util.Map;

public class QueryParamModel {

	private String sourceDB;
	private String destDB;
	private Map<String, Map<String,?>> mapSourcetoDest = new HashMap<String, Map<String,?>>();
	

	public Map<String, Map<String, ?>> getMapSourcetoDest() {
		return mapSourcetoDest;
	}

	public void setMapSourcetoDest(Map<String, Map<String, ?>> mapSourcetoDest) {
		this.mapSourcetoDest = mapSourcetoDest;
	}

	public String getSourceDB() {
		return sourceDB;
	}

	public void setSourceDB(String sourceDB) {
		this.sourceDB = sourceDB;
	}

	public String getDestDB() {
		return destDB;
	}

	public void setDestDB(String destDB) {
		this.destDB = destDB;
	}


}
