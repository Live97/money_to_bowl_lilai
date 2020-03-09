package com.amg.mall.util;

import org.springframework.util.StringUtils;

/**
 * Result工具类的进一步使用
 */
public class ResultGenerator {
    
    private static final String DEFAULT_SUCCRESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_SUCCESS_CODE = 200;
    private static final int RESULT_SERVER_ERROR_CODE = 500;
    
    public static Result getSuccessResult() {
        
        Result result = new Result();
        result.setMessage(DEFAULT_SUCCRESS_MESSAGE);
        result.setResultCode(RESULT_SUCCESS_CODE);
        return result;
    }
    public static Result getSuccessResult(String message) {
        
        Result result = new Result();
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setMessage(message);
        return result;
    }
    
    public static Result getSuccessResult(Object data) {
        Result result = new Result();
        result.setMessage(DEFAULT_SUCCRESS_MESSAGE);
        result.setResultCode(RESULT_SUCCESS_CODE);
        result.setData(data);
        return result;
    }
    public static Result getFailResult(String message) {
        
        Result result = new Result();
        if (StringUtils.isEmpty(message)){
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        result.setResultCode(RESULT_SERVER_ERROR_CODE);
        return result;
    }
    public static Result genErrorResult(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
