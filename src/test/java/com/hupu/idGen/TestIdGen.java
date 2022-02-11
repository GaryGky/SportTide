package com.hupu.idGen;

import com.hupu.utils.UserIdGen;
import org.junit.Test;

public class TestIdGen {
    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(UserIdGen.get().nextId());
        }
    }
}
