package hu.helixlab.buffet.Repository;

import hu.helixlab.buffet.Domain.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer>{

}

