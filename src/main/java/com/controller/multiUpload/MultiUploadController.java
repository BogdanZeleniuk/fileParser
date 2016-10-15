package com.controller.multiUpload;

import com.model.File;
import com.service.FileUploadService;
import com.util.ParsingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/multiUpload")
public class MultiUploadController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileUploadService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getMultiUploadPage(ModelMap model) {
        List<File> list = new ArrayList<>();
        model.addAttribute("multiFileBucket", list);
        return "multiFileUploader";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String multiFileUpload(@Valid MultipartHttpServletRequest request, Model model) throws IOException {

        List<String> fileNames = new ArrayList<>();
        File newFile;
        List<MultipartFile> listOfMultipartFiles = new ArrayList<>();
        MultipartFile someFileFromRequest;

        for (Iterator<String> it = request.getFileNames(); it.hasNext(); ) {
            someFileFromRequest = request.getFile(it.next());
            listOfMultipartFiles.add(someFileFromRequest);
        }

        for (MultipartFile multipartFile : listOfMultipartFiles) {

            String fileName = multipartFile.getOriginalFilename();
            if (!"".equalsIgnoreCase(fileName) && multipartFile.getBytes().length > 0
                    && "text/plain".equals(multipartFile.getContentType())) {
                newFile = new File();
                newFile.setFile(multipartFile.getBytes());
                service.save(newFile);
                fileNames.add(fileName);
            }
            else {
                log.debug("redirect to other page because of wrong types of files {}", multipartFile.getOriginalFilename());
                return "wrongPageForMultiFileUploader";
            }
        }

        List<String> listFiles = ParsingUtil.resultOfParsingListOfFiles(listOfMultipartFiles);
        int numberOfLines = ParsingUtil.countOfLinesInListOfFiles(listOfMultipartFiles);
        model.addAttribute("files", fileNames);
        model.addAttribute("listFiles", listFiles);
        model.addAttribute("numberOfLines", numberOfLines);
        return "multiSuccess";
    }
}
