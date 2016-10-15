package com.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParsingUtil {

    public static List<String> resultOfParsingOneFile(MultipartFile oneFile) throws IOException {
        Reader reader = new InputStreamReader(oneFile.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<String> list = new ArrayList<>();
        String line;
        while ((line=bufferedReader.readLine()) !=null){
            list.add(line);
        }
        return list;
    }
    public static int countOfLinesInFile(MultipartFile oneFile) throws IOException {
        List<String> list = resultOfParsingOneFile(oneFile);
        return list.size();
    }
    public static List<String> resultOfParsingListOfFiles(List<MultipartFile> listOfFiles) throws IOException {
        Reader reader;
        BufferedReader bufferedReader;
        List<String> list = new ArrayList<>();
        String line;
        for (MultipartFile listOfFile : listOfFiles) {
            reader = new InputStreamReader(listOfFile.getInputStream());
            bufferedReader = new BufferedReader(reader);
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        }
        return list;
    }
    public static int countOfLinesInListOfFiles(List<MultipartFile> listOfFiles) throws IOException {
        List<String> list = resultOfParsingListOfFiles(listOfFiles);
        return list.size();
    }
}
