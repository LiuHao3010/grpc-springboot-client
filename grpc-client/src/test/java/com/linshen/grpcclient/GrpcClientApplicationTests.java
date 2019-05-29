package com.linshen.grpcclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrpcClientApplicationTests {

    @Test
    public void contextLoads() {
        List<Integer> list=new ArrayList<Integer>();
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10000000;i++)
            {
//                for (int j=0;j<5;j++)
//                    list.add(i*j);
                test(i,i*2,i*3,i*4,i*5,list);
            }
        long endtTime=System.currentTimeMillis();
        System.out.println(startTime-endtTime);
    }
    public static void test(int i1,int i2,int i3,int i4,int i5,List list)
    {
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);
    }
}
