package main.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import main.entity.PersonInfo;

public class SimpleDao {

	private static List<PersonInfo> list;

	/**
	 * Get person detail by Id.
	 * @param id
	 * @return
	 */
	public synchronized static PersonInfo getPersonById(int id) {
		if (list == null) {
			list = getPersonInfoList();
		}
		if (list != null) {
			for (PersonInfo info : list) {
				if (info.getId() == id) {
					return info;
				}
			}
		}
		return null;
	}

	/**
	 * Grab person info list.
	 * @return
	 */
	public synchronized static List<PersonInfo> getPersonInfoList() {
		if (list == null) {
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<PersonInfo>>(){}.getType();
			String jsonStr = callURL("http://jsonplaceholder.typicode.com/users");
			list = gson.fromJson(jsonStr, listType);
		}
		return list;
	}

	private static String callURL(String myURL) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			urlConn.addRequestProperty("User-Agent", "Mozilla/4.76"); 
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while parsing URL:"+ myURL, e);
		} 
 
		return sb.toString();
	}
}
