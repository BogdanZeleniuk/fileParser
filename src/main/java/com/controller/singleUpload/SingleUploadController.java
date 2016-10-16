package com.controller.singleUpload;

import com.model.File;
import com.service.FileUploadService;
import com.util.ParsingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/singleUpload")
public class SingleUploadController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileUploadService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getSingleUploadPage(ModelMap model) {
        File fileModel = new File();
        model.addAttribute("fileBucket", fileModel);
        return "singleFileUploader";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String singleFileUpload(@Valid MultipartFile file, ModelMap model) throws IOException {

        if (file != null && file.getBytes().length >0 && "text/plain".equals(file.getContentType())
                && "text/plain".equals(file.getContentType())) {
                File newFile = new File();
                newFile.setFile(file.getBytes());
                service.save(newFile);
                List<String> fileNames = ParsingUtil.resultOfParsingOneFile(file);
                String fileName = file.getOriginalFilename();
                int numberLinesInFile = ParsingUtil.countOfLinesInFile(file);
                model.addAttribute("fileName", fileName);
                model.addAttribute("fileNames", fileNames);
                model.addAttribute("count", numberLinesInFile);
                return "success";
            }
                log.debug("redirect to other page because of wrong types of file {}", file.getOriginalFilename());
                return "wrongPageForSingleFileUploader";
    }
}
