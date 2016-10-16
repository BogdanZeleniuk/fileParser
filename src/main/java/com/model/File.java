package com.model;


import javax.persistence.*;
import java.util.Arrays;

@NamedQueries({
        @NamedQuery(name = File.DELETE, query = "DELETE FROM File file WHERE file.id=:id"),
        @NamedQuery(name = File.GET, query = "SELECT file FROM File file WHERE file.id=:id"),
        @NamedQuery(name = File.ALL, query = "SELECT file FROM File file")
})
@Entity
@Table(name = "files")
public class File {

    public static final String GET = "File.GET";
    public static final String ALL = "File.All";
    public static final String DELETE = "File.DELETE";

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "content", nullable=false)
    private byte[] content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getFile() {
        return content;
    }

    public void setFile(byte[] content) {
        this.content = content;
    }

    public File() {
    }

    public File(Integer id, byte[] content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }
        File file = (File) obj;
        if (id == null || file.id == null){
            return false;
        }
        return id.equals(file.id);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", file=" + Arrays.toString(content) +
                '}';
    }
}
