package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based ru.javawebinar.basejava.model.storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0; //количество резюме в массиве

    public void update(Resume r) {     //редактирование
        int tempIndex = getIndex(r.getUuid());
        if (tempIndex == -1) {
            System.out.println("Resume " + r.getUuid() + " not exist");
        } else {
            storage[tempIndex] = r;
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume r) {
        int tempIndex = getIndex(r.getUuid());
        if (tempIndex != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= storage.length) {
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
//                System.arraycopy(storage, i + 1, ru.javawebinar.basejava.model.storage, i, size - i);
            size--;
        }

    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        //System.out.println("ERROR резюме с таким uuid нет в базе");
        return -1;

    }


    /**
     * @return array, contains only Resumes in ru.javawebinar.basejava.model.storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = new Resume[size];
        System.arraycopy(storage, 0, result, 0, size);
        return result;
    }

    public int size() {
        return size;
    }
}