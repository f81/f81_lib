package com.fringe81.lib;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * JSONユーティリティ
 * 
 * @author asanuma
 * 
 */
public class JsonUtils {

	private static final ObjectMapper mapper = new ObjectMapper();

	private JsonUtils() {
	}

	/**
	 * JSON文字列をオブジェクトに変換する
	 * 
	 * @param str
	 *            JSON文字列
	 * @return オブジェクト(ObjectはMap, String, Listが基本の型っぽい)
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static Map<String, Object> convert(String str)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(str, new TypeReference<Map<String, Object>>() {
		});
	}

	/**
	 * JSONオブジェクトに変換する。
	 * 
	 * @param input
	 *            インプットストリーム
	 * @return JSONオブジェクト
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static Map<String, Object> convert(InputStream input)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(input,
				new TypeReference<Map<String, Object>>() {
				});
	}

	/**
	 * JSONオブジェクトに変換する。
	 * 
	 * @param str
	 *            文字列
	 * @return JSONオブジェクト
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static List<Map<String, Object>> convertList(String str)
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(str,
				new TypeReference<List<Map<String, Object>>>() {
				});
	}

	/**
	 * JSONオブジェクトを文字列変換する。
	 * 
	 * @param json
	 *            JSONオブジェクト
	 * @return 文字列
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static String convert(Object json) throws JsonGenerationException,
			JsonMappingException, IOException {
		return mapper.writeValueAsString(json);
	}

}
