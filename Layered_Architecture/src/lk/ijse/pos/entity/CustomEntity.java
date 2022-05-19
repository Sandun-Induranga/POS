package lk.ijse.pos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomEntity {
    private String id;
    private String name;
    private String address;
    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;
    private String oid;
    private LocalDate date;
    private String customerId;
    private String itemCode;
    private int qty;

    public CustomEntity(String oid, LocalDate date, String customerId, String code, int qty, BigDecimal unitPrice) {
        this.oid=oid;
        this.date=date;
        this.customerId=customerId;
        this.code=code;
        this.qty=qty;
        this.unitPrice=unitPrice;
    }
}
