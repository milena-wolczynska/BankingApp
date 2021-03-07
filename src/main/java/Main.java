import pl.sda.model.*;
import pl.sda.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Amount amount1 = new Amount(new BigDecimal(1000000), Currency.PLN);
        Amount amount2 = new Amount(new BigDecimal(5000000), Currency.DOLLAR);
        Amount amount3 = new Amount(new BigDecimal(2000000), Currency.EURO);
        BankAccount bankAccount1 = new BankAccount(amount1);
        BankAccount bankAccount2 = new BankAccount(amount2);
        BankAccount bankAccount3 = new BankAccount(amount3);
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(bankAccount1);
        accounts.add(bankAccount2);
        accounts.add(bankAccount3);
        Address address1 = new Address("Lodz","Mickiewicza","50B");
        User user1 = new User("Paul",address1,accounts);
        System.out.println(user1.toString());
        BigDecimal sumOfAmounts = user1.sumAmount();
        System.out.println(sumOfAmounts);
        User user= new User("KRzysztof",address1,accounts);
        User user2= new User("Tomek",address1,accounts);
        User user3= new User("Szymon",address1,accounts);
        User user4= new User("Mateusz",address1,accounts);
        user.setOpeningDate(LocalDate.of(2020,12,12));
        user2.setOpeningDate(LocalDate.of(2020,10,12));
        user3.setOpeningDate(LocalDate.of(2020,8,12));
        user4.setOpeningDate(LocalDate.of(2020,4,12));

        List<User> users= new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        UserService userService = new UserService();
        List<User> byDate = userService.findByDate(users, LocalDate.of(2020, 7, 12), LocalDate.of(2020, 12, 1));
        System.out.println(byDate);

    }
}