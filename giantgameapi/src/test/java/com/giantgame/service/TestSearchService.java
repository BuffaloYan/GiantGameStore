package com.giantgame.service;

import com.giantgame.model.GiantGameResponse;
import org.junit.Assert;
import org.junit.Test;

public class TestSearchService {
    SearchService service = new SearchService();

    @Test
    public void testSearch() {
        GiantGameResponse response = service.search("metroid prime");

        Assert.assertNotNull(response.getResults());
        Assert.assertTrue(response.getResults().length > 0);
    }
}
