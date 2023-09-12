package com.example.finalprojectbackend.lab2you.service.catalogservice;

import com.example.finalprojectbackend.lab2you.db.model.dto.CatalogDTO;
import com.example.finalprojectbackend.lab2you.db.model.entities.StatusEntity;
import com.example.finalprojectbackend.lab2you.db.model.wrappers.CatalogWrapper;
import com.example.finalprojectbackend.lab2you.db.repository.CatalogService;
import com.example.finalprojectbackend.lab2you.db.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("status")
public class StatusService implements CatalogService<StatusEntity> {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @CacheEvict(value = "statuses", allEntries = true)
    @Override
    public StatusEntity executeCreation(StatusEntity entity) {
        return statusRepository.save(entity);
    }

    @CacheEvict(value = "statuses",allEntries = true)
    @Override
    public StatusEntity executeUpdate(StatusEntity entity) {
        StatusEntity statusEntityFound = executeReadAll()
                .stream()
                .filter(statusEntity -> statusEntity.getId().equals(entity.getId())).findFirst()
                .orElse(null);

        if (statusEntityFound != null){
            statusEntityFound
                    .setName(entity.getName() != null ? entity.getName() : statusEntityFound.getName());
            statusEntityFound.setDescription(entity.getDescription() != null ? entity.getDescription()
                    : statusEntityFound.getDescription());
            statusRepository.save(statusEntityFound);
        }
        return statusEntityFound;
    }

    @Override
    public void executeDeleteById(Long id) {
        StatusEntity statusEntityFound = executeReadAll()
                .stream()
                .filter(statusEntity -> statusEntity.getId().equals(id)).findFirst().orElse(null);

        if(statusEntityFound != null){
            statusEntityFound.setIsDeleted(true);
            statusRepository.save(statusEntityFound);
        }
    }

    @Cacheable(value = "statuses")
    @Override
    public List<StatusEntity> executeReadAll() {
        return statusRepository.findAllByIsDeletedFalse();
    }

    @Override
    public String getCatalogName() {
        return "status";
    }

    @Override
    public CatalogWrapper mapToCatalogWrapper(StatusEntity catalogItem) {
        return new CatalogWrapper(catalogItem.getId(),catalogItem.getName(),catalogItem.getDescription());
    }

    @Override
    public StatusEntity mapToCatalogEntity(CatalogDTO catalogDTO) {
        return new StatusEntity(catalogDTO.getName(),catalogDTO.getDescription());
    }
}
