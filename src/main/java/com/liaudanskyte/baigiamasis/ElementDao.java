package com.liaudanskyte.baigiamasis;

import java.util.List;
import java.util.Optional;

public interface ElementDao<T> {
    //CRUD [personal note]
    T create(T element);

    List<T> getAllElements();

    Optional<T> getById(Long id);

    T updateElement(T element);

    void deleteElement(Long id);
}
