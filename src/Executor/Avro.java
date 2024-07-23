package Executor;

public class Avro {

    String tagId;
    String lastTagId;

    public Avro(String tagId) {
        this.tagId = tagId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getLastTagId() {
        return lastTagId;
    }

    public void setLastTagId(String lastTagId) {
        this.lastTagId = lastTagId;
    }
}
