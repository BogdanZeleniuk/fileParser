package com.service;

import com.repository.FileUploadRepository;
import com.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Async
public class FileUploadServiceImpl implements FileUploadService, Runnable{

    @Autowired
    private FileUploadRepository repository;

    @Override
    public File save(File someFile) {
        return repository.save(someFile);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public File get(int id) {
        return repository.get(id);
    }

    @Override
    public List<File> getAll() {
        return repository.getAll();
    }

    @Override
    public void run() {
        System.out.println("FileUploadServiceImpl");
    }
}
