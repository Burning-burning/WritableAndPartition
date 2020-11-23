package com.atguigu.WritableAndPartition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partiton extends Partitioner<Bean, Text> {
    @Override
    public int getPartition(Bean bean, Text text, int numPartitions) {
        switch (text.toString().substring(0,3)){
            case "136":
                return 0;
            case "137":
                return 1;
            case "138":
                return 2;
            case "139":
                return 3;
            default:
                return 4;
        }
    }
}
