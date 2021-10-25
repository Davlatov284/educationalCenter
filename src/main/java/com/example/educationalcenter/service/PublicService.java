package com.example.educationalcenter.service;

import java.util.List;
import java.util.Optional;

public interface PublicService<T, ID> {
    public List<T> getAll() throws Exception;
    public T add(T t) throws Exception;
    public void update(T t) throws Exception;
    public void delete();
    public void deleteById(ID id);

    Optional<T> getById(Long id);
}
