#!/bin/bash

# Script to upload a dataset to HDFS
# Author: Harshal Patil, Amey Managute, Prathamesh Gadgil

# Variables defination
DATASET_PATH="/data_jobs.csv"  
HDFS_INPUT_DIR="/input"          
HDFS_FILE_NAME="job_dataset.csv"          


# Creating an HDFS input directory
echo "Creating HDFS input directory"
hdfs dfs -mkdir -p $HDFS_INPUT_DIR

# Uploading the dataset to HDFS
echo "Uploading dataset to HDFS"
hdfs dfs -put -f $DATASET_PATH $HDFS_INPUT_DIR/$HDFS_FILE_NAME

# Verification of the uploading process
if hdfs dfs -test -e $HDFS_INPUT_DIR/$HDFS_FILE_NAME; then
    echo "Dataset successfully uploaded to HDFS"
    echo "HDFS Path: $HDFS_INPUT_DIR/$HDFS_FILE_NAME"
else
    echo "Error: upload to HDFS failed."
    exit 1
fi

# Listing the contents of the HDFS input directory
echo "Listing contents of $HDFS_INPUT_DIR:"
hdfs dfs -ls $HDFS_INPUT_DIR