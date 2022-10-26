package com.example.educationalinstitutions.base;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper<T extends BaseDto<ID> ,
        E extends BaseEntity<ID> ,
        ID extends Serializable> {

    E convertTToE(T t);

    T convertEToT(E e);

    List<E> convertListTToListE(List<T> tList);

    List<T> convertListEToListT(List<E> eList);
}
