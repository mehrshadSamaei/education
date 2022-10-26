package com.example.educationalinstitutions.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseDto<ID> , ID extends Serializable> {

    T saveOrUpdate(T t);

    void deleteById(ID id);

    List<T> findAll();

    T findById(ID id);

    Page<T> findAll(Pageable pageable);

}
