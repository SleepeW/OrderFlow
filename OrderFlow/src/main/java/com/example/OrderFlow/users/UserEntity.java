package com.example.OrderFlow.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="role", nullable = false)
    private int role; // 0 - user, 1 - admin

    @Column(name="balance", nullable = false)
    private Long balance = 0L;

    public void changeUsername(String username){
        if(username == null){
            throw new IllegalArgumentException();
        }

        this.username = username;
    }

    public void roleUser() {this.role = 0;}

    public void roleAdmin() {this.role = 1;}

    public void replenishment(Long sum){
        if(sum <= 0){
            throw new IllegalArgumentException();
        }

        this.balance += sum;
    }

    public void deduction(Long sum){
        if(sum <= 0 || balance < sum){
            throw new IllegalArgumentException();
        }

        this.balance -= sum;
    }
}
