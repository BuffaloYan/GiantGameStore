package com.giantgame.model;

public class SearchResult {
    String error;
    GameData[] results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public GameData[] getResults() {
        return results;
    }

    public void setResults(GameData[] results) {
        this.results = results;
    }
}
