package org.transportiq.models;

import java.util.HashMap;
import java.util.Map;

public class BaseModel {

    private Map<String, Object> fields = new HashMap<>();

    public void setField(String fieldName, Object value) {
        fields.put(fieldName, value);
    }

    public Object getField(String fieldName) {
        return fields.get(fieldName);
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}
