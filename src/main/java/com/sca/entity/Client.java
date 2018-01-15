package com.sca.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="clients")
@Getter
@Setter
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    @Size(min = 9, max = 12)
    private String phone;

    private Client() {

    }

    private Client(Builder builder) {
        id = builder.id;
        name = builder.name;
        lastName = builder.lastName;
        address = builder.address;
        phone = builder.phone;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String lastName;
        private String address;
        private String phone;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Client build() {
            return new Client(this);
        }

    }

}
