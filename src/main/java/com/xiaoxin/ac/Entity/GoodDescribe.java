package com.xiaoxin.ac.Entity;

import lombok.Data;

@Data
public class GoodDescribe {
    private String describe;
    private String url;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
