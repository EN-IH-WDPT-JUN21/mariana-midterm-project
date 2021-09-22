//package com.ironhack.midterm.banksystem.dao.account;
//import com.ironhack.midterm.banksystem.dao.user.AccountHolder;
//import com.ironhack.midterm.banksystem.utils.Money;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Optional;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Setter
//@Table(name = "account")
//public abstract class Account {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Long id;
//
//    @Column(name="account_balance")
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency")),
//            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
//
//    })
//    protected Money balance;
//
//    @OneToOne(mappedBy = "account")
//  //  @JoinColumn(name = "user_id")
//    protected AccountHolder primaryOwner;
//
////    @ManyToOne
////    @JoinColumn(name = "user_id", referencedColumnName = "id")
////    protected AccountHolder secondaryOwner;
//
//    //Constructor for no secondaryOwner
//    public Account(Money balance, AccountHolder primaryOwner) {
//        this.balance = balance;
//        this.primaryOwner = primaryOwner;
//    }
//
////    //Constructor with secondaryOwner
////    public Account(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
////        this.balance = balance;
////        this.primaryOwner = primaryOwner;
////        this.secondaryOwner = secondaryOwner;
////    }
//
////    @Override
////    public String toString() {
////
////        String toString = "Your account information:\n" +
////                "ID: " + getId() + "\n" +
////                "Balance: $ " + getBalance() + "\n" +
////                "Primary Account Holder: " + primaryOwner.getName();
////        if (secondaryOwner !=null){
////            toString += toString + "\nSecondary Account Holder: " + secondaryOwner.getName();
////        }
////
////        return toString;
////
////    }
//}
