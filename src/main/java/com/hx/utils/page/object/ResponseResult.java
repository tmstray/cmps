package com.hx.utils.page.object;

import java.util.HashMap;
import java.util.Map;

public class ResponseResult {

    private final boolean SUCCESS_STATUS = true;
    private Map<String, Object> response = new HashMap<>();

    public Map<String, Object> error() {
        response.put("success", !SUCCESS_STATUS);
        return response;
    }

    public Map<String, Object> success() {
        response.put("success", SUCCESS_STATUS);
        return response;
    }

    public Map<String, Object> error(String message) {
        response.put("success", !SUCCESS_STATUS);
        response.put("msg", message);
        return response;
    }

    public Map<String, Object> success(String message) {
        response.put("success", SUCCESS_STATUS);
        response.put("msg", message);
        return response;
    }

    public Map<String, Object> successWithPath(String path) {
        response.put("success", SUCCESS_STATUS);
        response.put("portrait_path", path);
        return response;
    }

}
