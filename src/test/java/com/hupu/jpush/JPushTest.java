package com.hupu.jpush;

import com.hupu.utils.Jpush;
import org.junit.Test;

import java.util.ArrayList;

public class JPushTest {
    private Jpush jpush = new Jpush();
    
    @Test
    public void test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("pxy");
        strings.add("");
        strings.add("zjy");
        for(String str:strings){
            jpush.jiguangPush(str,"TEST");
        }
    }
}
