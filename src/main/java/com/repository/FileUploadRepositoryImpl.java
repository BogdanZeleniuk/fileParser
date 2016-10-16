package com.repository;

import com.model.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class FileUploadRepositoryImpl implements FileUploadRepository {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public File save(File someFile) {
        log.info("SAVE file {}", someFile.getId());
            entityManager.persist(someFile);
            return someFile;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        log.info("DELETE file by id {}", id);
        return entityManager.createNamedQuery(File.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public File get(int id) {
        List<File> files = entityManager.createNamedQuery(File.GET,File.class)
                .setParameter("id", id)
                .getResultList();
        log.info("GET file by id {} ", id);
        return DataAccessUtils.singleResult(files);
    }

    @Override
    public List<File> getAll() {
        log.info("GET_ALL files {}");
        return entityManager.createNamedQuery(File.ALL, File.class)
                .getResultList();
    }
}
