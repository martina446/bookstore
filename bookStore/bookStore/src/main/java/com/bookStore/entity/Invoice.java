package com.bookStore.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Date date;

    @Column(columnDefinition = "tinyint(1) default 0") // popravljen bug s zapisom u bazu
    boolean payed;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    User user;

    public Invoice() {}

    public Invoice(Long id, Date date, boolean payed) {
        this.id = id;
        this.date = date;
        this.payed = payed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
