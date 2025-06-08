package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;

public class DataIngestion {
    public static void main(String[] args) {
        String localFilePath = "/Users/ameymanagute/Desktop/A Spring 2025/A_DIC/CSE587/CSE587Project/merged_data_jobs.csv";
        String hdfsDestPath = "/input/job_dataset.csv";

       
        String hdfsUri = "hdfs://127.0.0.1:9000";


        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        conf.set("fs.file.impl", "org.apache.hadoop.fs.LocalFileSystem");


        System.setProperty("hadoop.home.dir", "/opt/hadoop");

        try {

            FileSystem fs = FileSystem.get(URI.create(hdfsUri), conf);


            Path localPath = new Path(localFilePath);
            Path hdfsPath = new Path(hdfsDestPath);


            Path hdfsDir = new Path("/input");
            
            fs.copyFromLocalFile(false, true, localPath, hdfsPath);

            fs.close();

        } catch (IOException e) {
            System.err.println("Exception occurred while uploading to HDFS ")
        }
    }
}