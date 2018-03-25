package hu.helixlab.buffet.Repository;

import hu.helixlab.buffet.Domain.Product;
import hu.helixlab.buffet.Domain.ProductReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductReportRepository extends CrudRepository<Product, Integer> {
    @Query(value="\n" +
            "select sum (sale_product.quantity) as sum_quantity, product.product_name  from product inner join sale_product on product.id=sale_product.product_id\n" +
            "inner join sale on sale_product.sale_id=sale.id\n" +
            "where sale.sale_time>=date_trunc('month', clock_timestamp()) and sale.sale_time<date_trunc('month', clock_timestamp())+interval '1 month'\n" +
            "group by(product.product_name)\n" +
            "order by sum_quantity DESC", nativeQuery = true)
    public List<Object[]> productReport();
}
