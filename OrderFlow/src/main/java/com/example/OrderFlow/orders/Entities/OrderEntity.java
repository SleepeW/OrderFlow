package com.example.OrderFlow.orders.Entities;

import com.example.OrderFlow.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Getter
@NoArgsConstructor
@Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user_id;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at = Timestamp.from(Instant.now());

    @Column(name = "status", nullable = false)
    private int status;
//  1   -   CREATING [note: 'создаётся']
//  2   -   PENDING_PAYMENT [note: 'ожидает оплаты']
//  3   -   PAID [note: 'успешно оплачен']
//  4   -   PROCESSING [note: 'готовится к отправке']
//  5   -   SHIPPED [note: 'отправлен покупателю']
//  6   -   COMPLETED [note: 'заказ завершён']
//  7   -   CANCELLED [note: 'заказ отменён']
//  8   -   EXPIRED [note: 'срок оплаты истёк']

    @Column(name = "total_price", nullable = false)
    private int total_price;

    public void CREATINGStatus() {status = 1;}
    public void PENDING_PAYMENTStatus() {status = 2;}
    public void PAIDStatus() {status = 3;}
    public void PROCESSINGStatus() {status = 4;}
    public void SHIPPEDStatus() {status = 5;}
    public void COMPLETEDStatus() {status = 6;}
    public void CANCELLEDStatus() {status = 7;}
    public void EXPIREDStatus() {status = 8;}

    public void changeTotalPrice(int total_price){
        if(total_price < 0){
            throw new IllegalArgumentException();
        }

        this.total_price = total_price;
    }
}
