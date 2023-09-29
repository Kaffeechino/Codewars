package de.gfn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
        long n = 123456;
        assertEquals("2 6 157 12344",  d.decompose(n));
    }
}
