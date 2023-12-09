package com.example.keytrackerapi.models;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Getter
public abstract class BaseService<T, R extends JpaRepository<T, Long>> {

    protected final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public T findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public T save(T object) {
        return this.repository.save(object);
    }

    public boolean deleteById(Long id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
