package com.example.educationalinstitutions.base;

import com.example.educationalinstitutions.exceptions.NotFountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
//        e.setId(UUID.randomUUID().toString());
        E saveEntity = repository.save(e);
        return mapper.convertEToT(saveEntity);
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        T t = findById(id);
        E e = mapper.convertTToE(t);
        repository.delete(e);
    }

    @Override
    public List<T> findAll() {
        List<E> allEntities = repository.findAll();
        return mapper.convertListEToListT(allEntities);
    }

    @Override
    public T findById(ID id) {
        Optional<E> optionalE = repository.findById(id);
        if (optionalE.isPresent()){
            E e = repository.findById(id).get();
            return mapper.convertEToT(e);
        }else
            throw new NotFountEntity("not found your id");
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        Page<E> allPaginationEntities = repository.findAll(pageable);
        Page<T> map = allPaginationEntities.map(mapper::convertEToT);
        return map;
    }
}
