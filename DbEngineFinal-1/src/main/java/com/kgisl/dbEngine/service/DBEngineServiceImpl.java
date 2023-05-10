package com.kgisl.dbEngine.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgisl.dbEngine.entity.EisTrnCoverNote;
import com.kgisl.dbEngine.entity.EisTrnCoverNoteExt;
import com.kgisl.dbEngine.entity.QueryParamModel;
import com.kgisl.dbEngine.repository.DBEngineRepo;
import com.kgisl.dbEngine.repository.EisTrnCoverNoteExtRepo;
import com.kgisl.dbEngine.repository.EisTrnCoverNoteRepo;
import com.sun.tools.javac.code.TypeMetadata.Entry;

@Service
public class DBEngineServiceImpl implements DBEngineService {

	Logger logger = LoggerFactory.getLogger(DBEngineService.class);

	@Autowired
	private EisTrnCoverNoteRepo eisTrnCoverNoteRepo;

	@Autowired
	private DBEngineRepo dbEngineRepo;

	@Autowired
	private EisTrnCoverNoteExtRepo eisTrnCoverNoteExtRepo;

	public List<EisTrnCoverNote> getAllCoverNote() {
		return (List<EisTrnCoverNote>) eisTrnCoverNoteRepo.findAll();
	}

	public List<EisTrnCoverNoteExt> getAllCoverages() {

		return (List<EisTrnCoverNoteExt>) eisTrnCoverNoteExtRepo.findAll();
	}

	private void generateInsertionQueryAndExecute(HashMap<String, String> nameValuePairs, String destTable,
			String dbName) {

		Map<String, String> datatypeMapper = dbEngineRepo.fetchColumnType(destTable, dbName);

		String insertionQuery = constructInsertionQuery(datatypeMapper, nameValuePairs, destTable, dbName);

		dbEngineRepo.executeQuery(insertionQuery);

		logger.info(insertionQuery);

	}

	private String constructInsertionQuery(Map<String, String> datatypeMapper, HashMap<String, String> nameValuePairs,
			String destTable, String dbName) {

		String insertionQuery = "insert into " + dbName + "." + destTable + " (";
		String columnNames = "";
		String values = "";
		for (Map.Entry<String, String> entry : nameValuePairs.entrySet()) {
			if (columnNames.isEmpty())
				columnNames = columnNames + entry.getKey();
			else
				columnNames = columnNames + "," + entry.getKey();

			if (datatypeMapper.get(entry.getKey()).equalsIgnoreCase("varchar")
					|| datatypeMapper.get(entry.getKey()).equalsIgnoreCase("char")) {
				if (!(entry.getValue().startsWith("'") && entry.getValue().endsWith("'")))
					nameValuePairs.put(entry.getKey(), "'" + entry.getValue() + "'");
			}

			if (values.isEmpty())
				values = values + entry.getValue();
			else
				values = values + "," + entry.getValue();
		}

		insertionQuery = insertionQuery + columnNames + ") values(" + values + ");";

		return insertionQuery;
	}

	public JSONArray covertToJson(List<?> entityObj) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(entityObj);
		System.out.println(jsonString);
		JSONArray array = new JSONArray(jsonString);
		return array;
	}

	public Map<String, String> getCoumnType(String table, String db) {
		return dbEngineRepo.fetchColumnType(table, db);
	}

	public void copyColumnData(QueryParamModel queryParamModel, JSONArray jsonArray) throws JsonProcessingException {

		String sourceDB = queryParamModel.getSourceDB();
		String destDB = queryParamModel.getDestDB();
		Map<String, Boolean> parentExecuted = new HashMap<String, Boolean>();

//		logger.info("SourceDB : " + sourceDB);
//		logger.info("DestDB : " + destDB);

		for (int i = 0; i < jsonArray.length(); i++) {

			JSONObject srcJson = jsonArray.getJSONObject(i);

			for (Map.Entry<String, Map<String, ?>> tables : queryParamModel.getMapSourcetoDest().entrySet()) {

				HashMap<String, String> nameValuePairs = new HashMap<String, String>();

				String destParent = tables.getKey();

				parentExecuted.put(destParent, false);

				for (Map.Entry<String, ?> entry : tables.getValue().entrySet()) {

					if (entry.getKey().toString().contains(".")) {
						if (entry.getKey().split("\\.")[1].contains("IDENTIFY")) {

							if (srcJson.has(entry.getKey().split("\\.")[1].split(" IDENTIFY ")[1].toLowerCase())) {

								JSONObject obj1 = srcJson.getJSONObject(
										entry.getKey().split("\\.")[1].split(" IDENTIFY ")[1].toLowerCase());

								nameValuePairs.put(entry.getValue().toString().split("\\.")[1],
										obj1.getString(entry.getKey().split("\\.")[1].split(" IDENTIFY ")[0].toString()
												.toLowerCase()));
							} else {

								JSONObject parent = srcJson.getJSONObject("parent");

								JSONObject obj2 = parent.getJSONObject(
										entry.getKey().split("\\.")[1].split(" IDENTIFY ")[1].toLowerCase());

								nameValuePairs.put(entry.getValue().toString().split("\\.")[1], obj2.get(
										entry.getKey().split("\\.")[1].split(" IDENTIFY ")[0].toString().toLowerCase())
										.toString());
							}

						} else {
							if (srcJson.has(entry.getKey().split("\\.")[1].toString().toLowerCase()))
								nameValuePairs.put(entry.getValue().toString().split("\\.")[1], srcJson
										.get(entry.getKey().split("\\.")[1].toString().toLowerCase()).toString());
							else {
								JSONObject parent = srcJson.getJSONObject("parent");
								nameValuePairs.put(entry.getValue().toString().split("\\.")[1],
										parent.get(entry.getKey().split("\\.")[1].toString().toLowerCase()).toString());

							}
						}

//						logger.info("DestTable : " + destParent);
//						logger.info("Name:Value Pairs - " + nameValuePairs);

					} else {
						if (!parentExecuted.get(destParent)) {
							parentExecuted.put(destParent, true);
							generateInsertionQueryAndExecute(nameValuePairs, destParent, destDB);
						}
						String childTable = entry.getKey().toString();
						HashMap<String, String> nameValuePairsChild = new HashMap<String, String>();

						HashMap<String, String> childTableMapping = (HashMap<String, String>) entry.getValue();

						Set<Map.Entry<String, String>> childTableEntry = childTableMapping.entrySet();

						JSONObject parentJson = srcJson.getJSONObject("parent");

						if ((JSONArray) parentJson.get("extra_coverage") != null) {

							getNestedJSon("extra_coverage", parentJson, nameValuePairs, childTableMapping,
									childTableEntry, childTable, destParent, destDB);
						}
						if ((JSONArray) parentJson.get("named_driver") != null) {

							getNestedJSon("named_driver", parentJson, nameValuePairs, childTableMapping,
									childTableEntry, childTable, destParent, destDB);

						}
					}

				}
				if (!parentExecuted.get(destParent))
					generateInsertionQueryAndExecute(nameValuePairs, destParent, destDB);
			}

		}

	}

	private HashMap<String, String> getNestedJSon(String domain, JSONObject parentJson,
			HashMap<String, String> nameValuePairs, HashMap<String, String> childTableMapping,
			Set<Map.Entry<String, String>> childTableEntry, String childTable, String destParent, String destDB) {

		HashMap<String, String> childNameValuePairs = new HashMap<String, String>();
		JSONArray ja = (JSONArray) parentJson.get(domain);
		for (int j = 0; j < ja.length(); j++) {
			JSONObject obj = ja.getJSONObject(j);
			for (String key : childTableMapping.keySet()) {

				if (key.split("\\.")[0].equals(destParent)) {
					String value = nameValuePairs.get(key.split("\\.")[1]);
					childNameValuePairs.put(childTableMapping.get(key).split("\\.")[1], value);
				}

				else if (key.split("\\.")[1].contains(" IDENTIFY ")
						&& obj.has(key.split("\\.")[1].split(" IDENTIFY ")[1].toLowerCase())) {

					JSONObject obj1 = obj.getJSONObject(key.split("\\.")[1].split(" IDENTIFY ")[1].toLowerCase());

					childNameValuePairs.put(childTableMapping.get(key).split("\\.")[1],
							obj1.get(key.split("\\.")[1].split(" IDENTIFY ")[0].toLowerCase()).toString());

				} else if (obj.has(key.split("\\.")[1].toString().toLowerCase())) {

					childNameValuePairs.put(childTableMapping.get(key).split("\\.")[1],
							obj.get(key.split("\\.")[1].toString().toLowerCase()).toString());
				} else
					return null;

			}
//			logger.info("Child Table : " + childTable);
//			logger.info("Name:Value Pairs - " + childNameValuePairs);

			generateInsertionQueryAndExecute(childNameValuePairs, childTable, destDB);
			childNameValuePairs.clear();
		}

		return childNameValuePairs;

	}

}
