package cn.xj.project.model;

import javax.persistence.*;

/**
 * Created by Welink on 2017/5/5.
 */
@Entity
@Table(name = "cloudDemo")
public class CloudDemo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CloudDemo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
