package ch.zuehlke.chaoscamp.app;

import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LoadTest {

	@Test
	public void generateLoadOnApiWorld() throws InterruptedException {
		Random random = new Random();
		for (int i=0; i<10000; ++i) {
			try {
				int status = world(i);
				logInfo(i, "api/world' result: " + status);
			} catch (IOException e) {
				logError(i, e.getClass().getSimpleName() + " > " + e.getMessage());
			}
			Thread.sleep(100 + random.nextInt(1000));
		}
	}

	private static void logError(int index, String message) {
		log("[ERROR]", index, message);
	}

	private static void logInfo(int index, String message) {
		log("[INFO]", index, message);
	}

	private static void log(String level, int index, String message) {
		System.out.println(String.format("%-8s %5d: - %s", level, index, message));
	}

	private int world(int i) throws IOException {
		URL url = new URL("http://localhost:8081/api/world?value=test"+i);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		Map<String, String> parameters = new HashMap<>();
		parameters.put("value", "testval");

		con.disconnect();
		return con.getResponseCode();
	}

	static class ParameterStringBuilder {
		public static String getParamsString(Map<String, String> params)
				throws UnsupportedEncodingException {
			StringBuilder result = new StringBuilder();

			for (Map.Entry<String, String> entry : params.entrySet()) {
				result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
				result.append("=");
				result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				result.append("&");
			}

			String resultString = result.toString();
			return resultString.length() > 0
					? resultString.substring(0, resultString.length() - 1)
					: resultString;
		}
	}

}
