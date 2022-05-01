package com.giantgame.model;

public class GiantGameResponse {
    String error;
    GiantGame[] results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public GiantGame[] getResults() {
        return results;
    }

    public void setResults(GiantGame[] results) {
        this.results = results;
    }
}
