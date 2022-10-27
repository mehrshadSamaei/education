package com.example.educationalinstitutions.base;

import com.example.educationalinstitutions.exceptions.NotFountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseServiceImpl<T extends BaseDto<ID>,
        E extends BaseEntity<ID>,
        M extends BaseMapper<T, E, ID>,
        ID extends Serializable,
        R extends BaseRepository<E, ID>> implements BaseService<T, ID> {

    protected final R repository;

    protected final M mapper;

    @Override
    @Transactional
    public T saveOrUpdate(T t) {
        E e = mapper.convertTToE(t);
        E saveEntity = repository.save(e);
        return mapper.convertEToT(saveEntity);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        E e = repository.findById(id).get();
        repository.delete(e);
    }

    @Override
    public List<T> findAll() {
        List<E> allEntities = repository.findAll();
        return mapper.convertListEToListT(allEntities);
    }

    @Override
    public T findById(ID id) {
        E e = repository.findById(id).get();
        if (e.getId() == null){
            throw new NotFountEntity("not found your id");
        }
        return mapper.convertEToT(e);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        Page<E> allPaginationEntities = repository.findAll(pageable);
        Page<T> map = allPaginationEntities.map(mapper::convertEToT);
        return map;
    }
}
