package com.liaudanskyte.baigiamasis;

import java.util.List;

public interface ElementDao<T> {
    //CRUD [personal note]
    T create(T element);

    List<T> getAllElements();

    T getById(Long id);

    T updateElement(T element);

    void deleteElement(Long id);
}
