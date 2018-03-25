package hu.helixlab.buffet.Service;

import hu.helixlab.buffet.Domain.Sale;
import hu.helixlab.buffet.Repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }
}
