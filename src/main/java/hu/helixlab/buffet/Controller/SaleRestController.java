package hu.helixlab.buffet.Controller;

import hu.helixlab.buffet.Domain.Sale;
import hu.helixlab.buffet.Domain.SaleProduct;
import hu.helixlab.buffet.Service.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleRestController {
    @Autowired
    private SaleService saleService;



    @RequestMapping(value="/buffet/sale", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost")
    public Sale createSale (@RequestBody Sale sale) {
        for (SaleProduct sp : sale.getSaleProducts()) {
            sp.setSale(sale);
        }
        return saleService.save(sale);
    }
}
