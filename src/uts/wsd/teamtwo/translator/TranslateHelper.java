package uts.wsd.teamtwo.translator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;

public class TranslateHelper {

	/**
	 * Returns an accessToken that can be used to access the Microsoft
	 * Translator service.
	 * 
	 * Makes a HTTP post request following the OAuth 2.0 standard. The
	 * result is returned in JSON format, so this is parsed to extract
	 * the accessToken.
	 * 
	 * Note that the accessToken expires after 10 minutes and a new
	 * accessToken will need to be obtained.
	 * 
	 * @param clientId The client ID that you specified when you registered your application with Azure DataMarket. 
	 * @param clientSecret The client secret value that you obtained when you registered your application with Azure DataMarket. 
	 * @return An accessToken that can be used to access the Microsoft Translate service.
	 */
	public static String getAccessToken(String clientId, String clientSecret) {
		String accessToken = null;
		try {
			// Assemble POST content
			String content = "grant_type=client_credentials";
			content += "&client_id=" + clientId;
			content += "&client_secret=" + URLEncoder.encode(clientSecret, StandardCharsets.UTF_8.toString());
			content += "&scope=http://api.microsofttranslator.com";

			// Set up HTTP connection (URLConnection)
			URL url = new URL("https://datamarket.accesscontrol.windows.net/v2/OAuth2-13/");
			URLConnection conn = url.openConnection();

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// Send POST output
			DataOutputStream printout = new DataOutputStream(conn.getOutputStream());
			printout.writeBytes(content);
			printout.flush();
			printout.close();

			// Get POST response
			DataInputStream input = new DataInputStream(conn.getInputStream());

			// Response is in JSON format. Extract the access_token from JSON
			JsonReader jreader = Json.createReader(input);
			JsonStructure jstructure = jreader.read();
			if (jstructure.getValueType() == JsonValue.ValueType.OBJECT) {
				JsonObject jobj = (JsonObject) jstructure;
				accessToken = jobj.getJsonString("access_token").getString();
			}
		} catch (IOException e) {
			// Something went wrong - reset accessToken to null
			accessToken = null;
		}
		return accessToken;
	}

}