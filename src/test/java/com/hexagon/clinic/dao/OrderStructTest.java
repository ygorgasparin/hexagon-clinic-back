package com.hexagon.clinic.dao;

import org.junit.Assert;
import org.junit.Test;

public class OrderStructTest {

    @Test
    public void testStruct_nullValues() throws Exception {
        OrderStruct s = new OrderStruct(null);

        Assert.assertNull(s.getDescOrder());
        Assert.assertNull(s.getPathOrder());
        Assert.assertNull(s.getRawOrder());
    }

    @Test
    public void testStruct_desc() throws Exception {
        String f = "field";

        OrderStruct s = new OrderStruct("-" + f);

        Assert.assertEquals(f, s.getPathOrder());
        Assert.assertTrue(s.getDescOrder());
    }

    @Test
    public void testStruct_asc() throws Exception {
        String f = "field";

        OrderStruct s = new OrderStruct(f);

        Assert.assertEquals(f, s.getPathOrder());
        Assert.assertFalse(s.getDescOrder());
    }


}