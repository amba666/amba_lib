package org.smartregister.chw.amba.util;

public interface Constants {

    int REQUEST_CODE_GET_JSON = 2244;
    String ENCOUNTER_TYPE = "encounter_type";
    String STEP_ONE = "step1";
    String STEP_TWO = "step2";

    interface JSON_FORM_EXTRA {
        String JSON = "json";
        String ENCOUNTER_TYPE = "encounter_type";
    }

    interface EVENT_TYPE {
        String AMBA_CONFIRMATION = "Amba Confirmation";
        String AMBA_FOLLOW_UP_VISIT = "Amba Follow-up Visit";
    }

    interface FORMS {
        String AMBA_REGISTRATION = "amba_confirmation";
        String AMBA_FOLLOW_UP_VISIT = "amba_followup_visit";
    }

    interface TABLES {
        String AMBA_CONFIRMATION = "ec_amba_confirmation";
        String AMBA_FOLLOW_UP = "ec_amba_follow_up_visit";
    }

    interface ACTIVITY_PAYLOAD {
        String BASE_ENTITY_ID = "BASE_ENTITY_ID";
        String FAMILY_BASE_ENTITY_ID = "FAMILY_BASE_ENTITY_ID";
        String ACTION = "ACTION";
        String AMBA_FORM_NAME = "AMBA_FORM_NAME";

    }

    interface ACTIVITY_PAYLOAD_TYPE {
        String REGISTRATION = "REGISTRATION";
        String FOLLOW_UP_VISIT = "FOLLOW_UP_VISIT";
    }

    interface CONFIGURATION {
        String AMBA_CONFIRMATION = "amba_confirmation";
    }

    interface AMBA_MEMBER_OBJECT {
        String MEMBER_OBJECT = "memberObject";
    }

}