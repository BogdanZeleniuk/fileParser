package com.service;

import com.model.File;

import java.util.List;

public interface FileUploadService {

    File save(File someFile);

    void delete(int id);

    File get(int id);

    List<File> getAll();
}
