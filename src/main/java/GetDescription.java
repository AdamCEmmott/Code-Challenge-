import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class GetDescription {

	/*
	 Takes a JSON string and converts to a JSON object drills down to find the required fields and returns a list of those definitions.
	 */
	public List<String> definitions(String payload) throws JSONException {

		if (payload == null || payload.isEmpty()) {
			return null;
		}

		JSONObject jsonObj = new JSONObject(payload);
		JSONArray startingPoint = jsonObj.getJSONArray("results").getJSONObject(0).getJSONArray("lexicalEntries")
				.getJSONObject(0).getJSONArray("entries").getJSONObject(0).getJSONArray("senses");

		List<String> descriptions = new ArrayList<>();

		for (int i = 0; i < startingPoint.length(); i++) {

			String description = startingPoint.getJSONObject(i).getJSONArray("definitions").toString().replace("[", "")
					.replace("]", "");

			descriptions.add(description);
		}

		return descriptions;

	}

}
