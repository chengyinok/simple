package com.study.dto;

public class ResponseVo {

    private boolean successful = true;

    private String message;

    private Object data;

    private String url;

    public ResponseVo(){

    }
    public ResponseVo(boolean successful, Object data) {
        this.successful = successful;
        this.data = data;
    }

    public ResponseVo(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public ResponseVo(boolean successful, String message, Object data) {
        this.successful = successful;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "successful=" + successful +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", url='" + url + '\'' +
                '}';
    }
}
