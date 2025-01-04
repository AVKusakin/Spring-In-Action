package tacos;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import tacos.data.IngredientRepository;
import tacos.data.OrderRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@WebMvcTest()
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration()
    static class TestConfig {

        @Bean
        public IngredientRepository ingredientRepository() {
            return new IngredientRepository() {
                @Override
                public <S extends Ingredient> S save(S entity) {
                    return null;
                }

                @Override
                public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities) {
                    return null;
                }

                @Override
                public Optional<Ingredient> findById(String s) {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(String s) {
                    return false;
                }

                @Override
                public Iterable<Ingredient> findAll() {
                    return null;
                }

                @Override
                public Iterable<Ingredient> findAllById(Iterable<String> strings) {
                    return null;
                }

                @Override
                public long count() {
                    return 0;
                }

                @Override
                public void deleteById(String s) {

                }

                @Override
                public void delete(Ingredient entity) {

                }

                @Override
                public void deleteAllById(Iterable<? extends String> strings) {

                }

                @Override
                public void deleteAll(Iterable<? extends Ingredient> entities) {

                }

                @Override
                public void deleteAll() {

                }
            };
        }

        @Bean
        public OrderRepository orderRepository() {
            return new OrderRepository() {
                @Override
                public List<TacoOrder> findByDeliveryZip(String deliveryZip) {
                    return List.of();
                }

                @Override
                public List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate) {
                    return List.of();
                }

                @Override
                public <S extends TacoOrder> S save(S entity) {
                    return null;
                }

                @Override
                public <S extends TacoOrder> Iterable<S> saveAll(Iterable<S> entities) {
                    return null;
                }

                @Override
                public Optional<TacoOrder> findById(Long aLong) {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(Long aLong) {
                    return false;
                }

                @Override
                public Iterable<TacoOrder> findAll() {
                    return null;
                }

                @Override
                public Iterable<TacoOrder> findAllById(Iterable<Long> longs) {
                    return null;
                }

                @Override
                public long count() {
                    return 0;
                }

                @Override
                public void deleteById(Long aLong) {

                }

                @Override
                public void delete(TacoOrder entity) {

                }

                @Override
                public void deleteAllById(Iterable<? extends Long> longs) {

                }

                @Override
                public void deleteAll(Iterable<? extends TacoOrder> entities) {

                }

                @Override
                public void deleteAll() {

                }
            };
        }
    }

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Welcome to...")));
    }
}