package org.smartregister.chw.amba.model;

import org.json.JSONObject;
import org.smartregister.chw.amba.contract.AmbaRegisterContract;
import org.smartregister.chw.amba.util.AmbaJsonFormUtils;

public class BaseAmbaRegisterModel implements AmbaRegisterContract.Model {

    @Override
    public JSONObject getFormAsJson(String formName, String entityId, String currentLocationId) throws Exception {
        JSONObject jsonObject = AmbaJsonFormUtils.getFormAsJson(formName);
        AmbaJsonFormUtils.getRegistrationForm(jsonObject, entityId, currentLocationId);

        return jsonObject;
    }

}
