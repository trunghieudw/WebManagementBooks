package Entities;

import java.io.Serializable;

public class Authors implements Serializable {
    private String authorId;
    private String name;

    public Authors(String authorId, String name) {
        this.authorId = authorId;
        this.name = name;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }
}

