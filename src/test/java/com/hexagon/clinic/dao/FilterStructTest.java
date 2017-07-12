package com.hexagon.clinic.dao;

import org.junit.Assert;
import org.junit.Test;

public class FilterStructTest {

    @Test
    public void testStruct_nullValues() throws Exception {
        FilterStruct filterStruct = new FilterStruct(null);

        Assert.assertNull(filterStruct.getFilterValue());
        Assert.assertNull(filterStruct.getPathFilter());
        Assert.assertNull(filterStruct.getRawFilter());
    }

    @Test(expected = Exception.class)
    public void testStruct_excpetion() throws Exception {
        new FilterStruct("asdsa");
    }

    @Test
    public void testStruct_success() throws Exception {
        String path = "path";
        String value = "value";
        FilterStruct filterStruct = new FilterStruct(path + ":" + value);

        Assert.assertEquals(path, filterStruct.getPathFilter());
        Assert.assertEquals(value, filterStruct.getFilterValue());
    }

}