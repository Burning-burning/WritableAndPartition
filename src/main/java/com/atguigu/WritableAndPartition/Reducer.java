package com.atguigu.WritableAndPartition;

import org.apache.hadoop.io.Text;

import java.io.IOException;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<Bean,Text,Text, Bean> {

    @Override
    protected void reduce(Bean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value:values){
            context.write(value,key);
        }
    }
}
