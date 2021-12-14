package com.trakor.Model;

public class ErrorResult {
    private String message;
    private int errorCode;

    public ErrorResult(String message, int errorCode) {
        this.setMessage(message);
        this.setErrorCode(errorCode);
    }

    /**
     * Get Error message.
     * 
     * @return String Error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Error message.
     * 
     * @param message Error message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get Error code.
     * 
     * @return int Error code.
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Set Error code.
     * 
     * @param errorCode Error code.
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "{\"message\":\"" + this.message + "\", \"code\":" + this.errorCode + "}";
    }

}
