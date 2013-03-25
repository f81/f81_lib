package com.fringe81.lib.csv;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.text.StrTokenizer;

public class CsvTokenizer implements Iterator<Object> {

	private final BufferedReader reader;

	private final String charset;

	private String nextLine = null;

	public CsvTokenizer(InputStream input, String charset)
			throws UnsupportedEncodingException {
		if (input == null) {
			throw new IllegalArgumentException("input is null.");
		}
		if (charset == null) {
			throw new IllegalArgumentException("charset is null.");
		}

		this.charset = charset;
		this.reader = new BufferedReader(new InputStreamReader(input,
				this.charset));
	}

	public CsvTokenizer(File file, String charset)
			throws FileNotFoundException, UnsupportedEncodingException {
		this(new FileInputStream(file), charset);
	}

	public CsvTokenizer(String input, String charset)
			throws UnsupportedEncodingException {
		this(new ByteArrayInputStream(input.getBytes()), charset);
	}

	@Override
	public boolean hasNext() {
		try {
			this.nextLine = this.reader.readLine();
		} catch (IOException e) {
			IOUtils.closeQuietly(this.reader);
			throw new RuntimeException(e);
		}

		if (this.nextLine != null) {
			return true;
		}

		IOUtils.closeQuietly(this.reader);
		return false;
	}

	@Override
	public Object next() {
		if (this.nextLine == null) {
			throw new NoSuchElementException();
		}

		return StrTokenizer.getCSVInstance(this.nextLine);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
