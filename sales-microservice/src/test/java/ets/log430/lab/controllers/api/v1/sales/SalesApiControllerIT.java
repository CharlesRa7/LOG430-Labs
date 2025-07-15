// src/test/java/ets/log430/lab/controllers/api/v1/sales/SalesApiControllerIntegrationTest.java
package ets.log430.sales.controllers.api.v1.sales;

import ets.log430.sales.SalesApplication;
import ets.log430.sales.models.product.Product;
import ets.log430.sales.models.sales.Sale;
import ets.log430.sales.models.sales.SaleProduct;
import ets.log430.sales.models.store.Store;
import ets.log430.sales.models.user.User;
import ets.log430.sales.repositories.product.ProductRepository;
import ets.log430.sales.repositories.sales.SalesRepository;
import ets.log430.sales.repositories.store.StoreRepository;
import ets.log430.sales.repositories.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SalesApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class SalesApiControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        User user = userRepository.save(new User("Alice Smith", "alice@example.com"));
        Store store = storeRepository.save(new Store("Store A"));
        Product product = productRepository.save(new Product("Product A", 100.0));
        BigDecimal totalAmount = BigDecimal.valueOf(200.0);
        Sale sale = salesRepository.save(new Sale(
                store,
                LocalDateTime.now().minusDays(1),
                totalAmount,
                user
        ));

        sale.addItem(new SaleProduct(product, 2, 100.0));
        salesRepository.save(sale);
    }

    @Test
    void getSalesForPeriod_shouldReturnOkAndJsonArray() throws Exception {
        mockMvc.perform(get("/api/v1/sales/period")
                        .param("startDate", "2024-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray());
    }
}