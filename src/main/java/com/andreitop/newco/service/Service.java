package com.andreitop.newco.service;

import com.andreitop.newco.dto.DTO;
import com.andreitop.newco.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public abstract class Service<D extends DTO>  {

    private Repository<D> repository;

    @Autowired
    public Service(Repository<D> repository) {
        this.repository = repository;
    }

    Service() {}

    public void save(D entity) {
        repository.save(entity);
    }

    public void update(D entity) {
        repository.update(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public D findById(Long id) {
        return repository.findById(id);
    }

    public List<D> findAll() {
        return repository.findAll();
    }
}