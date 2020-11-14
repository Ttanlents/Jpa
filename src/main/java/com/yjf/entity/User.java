package com.yjf.entity;

import javax.persistence.*;

/**
 * @author 余俊锋
 * @date 2020/11/11 10:45
 * @Description
 */
@Table(name = "my_user")
@Entity
public class User {
    @Column(name = "id")
    @Id()
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    Integer id;
    @Column(name = "name")
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
