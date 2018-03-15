import dao.hibernate.ManufacturerDAOImpl;
import dao.hibernate.ProductDAOImpl;
import servlet.Manufacturing;

public class Main {
    public static void main(String[] args) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        System.out.println(productDAO.getAll());
    }
}
