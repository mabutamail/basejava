package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based ru.javawebinar.basejava.model.storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage{

    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int tempIndex = getIndex(uuid);
        if (tempIndex == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[tempIndex];
    }

    protected abstract int getIndex(String uuid);

}