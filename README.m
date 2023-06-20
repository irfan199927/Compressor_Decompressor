﻿# Compressor_Decompressor

#Compressor 
The provided code is part of a project related to file compression and decompression. Specifically, it includes a Java class named Compressor that contains a method compressFile() responsible for compressing a file using GZIP compression.

The compressFile() method takes a File object as input, representing the file to be compressed. It reads the contents of the input file using a FileInputStream, creates a GZIPOutputStream to compress the data, and writes the compressed data to a new file with the extension ".gz" in the same directory as the original file.

The code uses a buffer of size 1024 bytes to read and write the file data in chunks. It iterates over the input file, reading chunks of data, compressing them using GZIP, and writing the compressed data to the output stream.

Overall, this code snippet provides a basic implementation for compressing a file using GZIP compression, making it smaller in size and potentially more efficient for storage or transmission purposes.

#Decompressor 

The provided code is a Java class named Decompressor that contains a method decompressFile() for decompressing a GZIP-compressed file. This code is intended to be part of a larger project related to file compression and decompression.

Here's a summary of the code:

The Decompressor class defines a single static method decompressFile() that takes a File object as a parameter. The method throws an IOException if there's an error during the decompression process.

The method retrieves the parent directory of the input file using file.getParent() to determine where the decompressed file will be stored.

It creates a FileInputStream to read the contents of the compressed file (file), and a GZIPInputStream to decompress the data from the input stream.

A FileOutputStream is created to write the decompressed data to a new file named "DecompressedFile" in the same directory as the original compressed file.

The method reads the compressed data from the GZIPInputStream in chunks (buffer) and writes the decompressed data to the output stream (fos).

Once the decompression is complete, the method closes the GZIPInputStream, FileOutputStream, and FileInputStream to release the resources.

This code provides a basic implementation for decompressing GZIP-compressed files in Java. However, it is important to note that this class alone does not constitute a complete project. It is likely that this class would be used in conjunction with other classes and functionality to create a comprehensive file compression and decompression system.



