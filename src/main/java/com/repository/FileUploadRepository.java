package com.repository;

import com.model.File;

import java.util.List;

public interface FileUploadRepository {

    File save(File someFile);

    boolean delete(int id);

    File get(int id);

    List<File> getAll();

}
