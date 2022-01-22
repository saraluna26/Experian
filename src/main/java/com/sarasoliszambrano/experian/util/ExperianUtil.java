package com.sarasoliszambrano.experian.util;

import com.sarasoliszambrano.experian.model.ExperianModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExperianUtil {

    public static List<ExperianModel> fromJSONToExperianModel(List<JSONObject> valuesJson) throws JSONException {
        List<ExperianModel> experianModelList = new ArrayList<>();
        for (JSONObject value : valuesJson) {
           // JSONArray data = (JSONArray) value.get("data");
           /* for (int i = 0; i < data.length(); i++) {
                JSONObject element = (JSONObject) data.get(i);

                String companyName = element.getString("companyName");
                Date registrationDate = (Date) element.get("registrationDate");
                Float score = (Float) element.get("score");
                Integer directorsCount = element.getInt("directorsCount");
                Date lastUpdated = (Date) element.get("lastUpdated"); */

            JSONObject companyNameObject = (JSONObject) value.get("");
            String companyName = companyNameObject.getString("companyName");

            Date registrationDate = (Date) value.get("registrationDate");
            Float score = (Float) value.get("score");
            Integer directorsCount = (Integer) value.get("directorsCount");
            Date lastUpdated = (Date) value.get("lastUpdated");

            experianModelList.add(new ExperianModel(companyName, registrationDate, score, directorsCount, lastUpdated));
            //}
        }
        return experianModelList;
    }
}
