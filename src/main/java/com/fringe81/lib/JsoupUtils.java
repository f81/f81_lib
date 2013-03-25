package com.fringe81.lib;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtils {

	private JsoupUtils() {
	}

	/**
	 * DOMに変換する
	 * 
	 * @param html
	 * @return
	 */
	public static Document convertDom(String html) {
		return Jsoup.parse(html);
	}

	/**
	 * DOMに変換する
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static Document convertDom(InputStream input) throws IOException {
		final String content = IOUtils.toString(input, "utf-8");
		return Jsoup.parse(content);
	}
}
