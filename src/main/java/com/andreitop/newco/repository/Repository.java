package com.andreitop.newco.repository;

import com.andreitop.newco.dto.DTO;

import java.util.ArrayList;
import java.util.List;


abstract class Repository<D extends DTO> {

    private List<D> eList = new ArrayList<>();

    public void save(D entity) {
        entity.setId((long) (eList.size() + 1));
        eList.add(entity);
    }

    public void update(D entity) {
        eList.stream()
             .filter(t -> t.getId().equals(entity.getId()))
             .findFirst()
             .ifPresent(t -> eList.set(eList.indexOf(t), entity));
    }

    public void deleteById(Long id) {
        eList.stream()
             .filter(t -> t.getId().equals(id))
             .findFirst()
             .ifPresent(eList::remove);
    }

    public D findById(Long id) {
        return eList.stream()
                    .filter(t -> t.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    public List<D> findAll() {
        return eList;
    }
}