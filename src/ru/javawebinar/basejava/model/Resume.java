package ru.javawebinar.basejava.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String Uuid;

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        this.Uuid = uuid;
    }

    @Override
    public String toString() {
        return getUuid();
    }
}
