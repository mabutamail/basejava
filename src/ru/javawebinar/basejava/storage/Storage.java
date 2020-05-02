package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;
//TODO refactoring
public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();
    //List<Resume> getAllSorted

    int size();
}