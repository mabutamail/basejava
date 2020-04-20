package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based ru.javawebinar.basejava.model.storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    private static final int STORAGE_LIMIT = 10_000;

    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int tempIndex = getIndex(r.getUuid());
        if (tempIndex == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[tempIndex] = r;
        }
    }

    public void save(Resume r) {
        int tempIndex = getIndex(r.getUuid());
        if (tempIndex != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public Resume get(String uuid) {
        int tempIndex = getIndex(uuid);
        if (tempIndex == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[tempIndex];
    }

    public void delete(String uuid) {
        int tempIndex = getIndex(uuid);
        if (tempIndex == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            storage[tempIndex] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
//        Resume[] result = new Resume[size];
//        System.arraycopy(storage, 0, result, 0, size);
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

}