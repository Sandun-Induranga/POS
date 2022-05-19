package lk.ijse.pos.entity;

import java.time.LocalDate;

public class Orders {
    private String oid;
    private LocalDate date;
    private String customer;

    public Orders(String oid, LocalDate date, String customer) {
        this.oid = oid;
        this.date = date;
        this.customer = customer;
    }

    public Orders() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
