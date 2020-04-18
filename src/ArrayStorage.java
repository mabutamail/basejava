/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0; //количество резюме в массиве

    public void clear() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                storage[i] = null;
            }
            size = 0;
        }
    }

    public void save(Resume r) {
        storage[size] = r; //добавить новое резюме
        size++;
    }

    public Resume get(String uuid) {
        Resume temp = null;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                temp = storage[i];
            }
        }
        return temp;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, size - i);
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] copyStorage = new Resume[size];
        System.arraycopy(storage, 0, copyStorage, 0, size);
        return copyStorage;
    }

    public int size() {
        return size;
    }
}