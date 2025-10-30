import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Department department = new Department(1, "Books");
        System.out.println(department);

        Seller seller = new Seller(1, "John", "john@mgmail.com", LocalDate.now(), 1500d, department);
        System.out.println(seller);

        SellerDao sellerDao = DaoFactory.createSellerDao();
    }
}
