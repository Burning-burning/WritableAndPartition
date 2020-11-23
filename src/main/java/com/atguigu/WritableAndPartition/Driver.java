package com.atguigu.WritableAndPartition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Job job = Job.getInstance(new Configuration());
        job.setJarByClass(Driver.class);
        job.setMapperClass(Mapper.class);
        job.setReducerClass(Reducer.class);

        job.setMapOutputKeyClass(Bean.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Bean.class);

        job.setPartitionerClass(Partiton.class);
        job.setNumReduceTasks(5);

        FileInputFormat.setInputPaths(job, new Path("d:\\input"));
        FileOutputFormat.setOutputPath(job, new Path("d:\\output"));

        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}