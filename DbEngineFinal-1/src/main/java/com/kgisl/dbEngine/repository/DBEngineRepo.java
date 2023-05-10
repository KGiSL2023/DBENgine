package com.kgisl.dbEngine.repository;

import java.util.Map;

public interface DBEngineRepo {

	Map<String, String> fetchColumnType(String tableName, String dbName);

	void executeQuery(String insertionQuery);

}
