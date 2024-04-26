import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import
        org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testFioProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/fio")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("fio", "Test FIO"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }
    @Test
    public void testTelProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tel")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("tel", "1234567890"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }
    @Test
    public void testEmailProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/email")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }}

import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import java.util.Arrays;
        import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CartRepository cartRepo;

    @InjectMocks
    private CartController cartController;

    // Метод теста для проверки работы контроллера customerCart
    @Test
    public void testCustomerCart() throws Exception {
        // Подготовка данных для запроса
        Long currentUserId = 1L; // Пример ID текущего пользователя
        List<CartItem> cartItems = Arrays.asList(
                new CartItem("Item1", currentUserId),
                new CartItem("Item2", currentUserId)
        );
        // Мокирование вызова репозитория для возврата списка товаров в корзине
        when(cartRepo.findAllByCustomerId(currentUserId)).thenReturn(cartItems);
        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/cart"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("cartItems"))
                .andExpect(MockMvcResultMatchers.model().attribute("cartItems", cartItems))
                .andExpect(MockMvcResultMatchers.view().name("customerCart"));
    }

    // Метод теста для проверки работы контроллера searchCartItem
    @Test
    public void testSearchCartItem() throws Exception {
        // Параметры запроса
        String itemName = "Item";
        // Подготовка данных для запроса
        List<CartItem> searchedItems = Arrays.asList(
                new CartItem("Item1"),
                new CartItem("Item2")
        );
        // Мокирование вызова репозитория для возврата списка товаров, соответствующих запросу
        when(cartRepo.findAllByItemNameContaining(itemName)).thenReturn(searchedItems);
        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/cart/search").param("itemName", itemName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("searchedItems"))
                .andExpect(MockMvcResultMatchers.model().attribute("searchedItems", searchedItems))
                .andExpect(MockMvcResultMatchers.view().name("customerCart"));
    }
}

import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import
        org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import java.util.Arrays;
        import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserRepository userRepo;
14
    @InjectMocks
    private UserController userController;

    @Test
    public void testUsers() throws Exception {
// Подготовка данных для запроса
        List<Restaurants> restaurant = Arrays.asList(
                new Restaurants("John Doe", Role.Restaurants
                );
// Мокирование вызова репозитория для возврата списка учителей
        when(userRepo.findAllByRole(Role.MANAGER)).thenReturn(restaurants);
// Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("restaurants"))
                .andExpect(MockMvcResultMatchers.model().attribute("restaurants ", teachers))
                .andExpect(MockMvcResultMatchers.view().name("restaurants "));
    }
    @Test
    public void testRestaurants() throws Exception {
// Параметры запроса
        String restaurants = "John";
// Подготовка данных для запроса
        List<restaurants> restaurants = Arrays.asList(
                new User("John Doe", Role.Restaurants),
                );
// Мокирование вызова репозитория для возврата списка учителей,
        соответствующих запросу
        when(userRepo.findAllByRoleAndrestaurantsContaining(Role.restaurants,
                menu)).thenReturn(restaurants);
// Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/search").param("name",
                        name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("name"))
                .andExpect(MockMvcResultMatchers.model().attribute("name",
                        name))
                .andExpect(MockMvcResultMatchers.model().attributeExists("restaurants"))
                .andExpect(MockMvcResultMatchers.model().attribute("restaurants", restaurants))
                .andExpect(MockMvcResultMatchers.view().name("restaurants"));
    }
}

import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import org.springframework.ui.Model;
        import static org.mockito.Mockito.when;
        import static org.mockito.Mockito.any;
        import static org.mockito.Mockito.anyLong;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RestaurantRepository restaurantRepo;

    @InjectMocks
    private RestaurantController restaurantController;

    // Тестирование метода getRestaurantInfo
    @Test
    public void testGetRestaurantInfo() throws Exception {
        // Подготовка данных для запроса
        RestaurantInfo restaurantInfo = new RestaurantInfo();
        restaurantInfo.setAdminId(1L); // Пример ID администратора
        restaurantInfo.setName("Test Restaurant");
        restaurantInfo.setAddress("Test Address");

        // Мокирование вызова репозитория для возврата информации о ресторане
        when(restaurantRepo.findRestaurantInfoByAdminId(anyLong())).thenReturn(restaurantInfo);

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("restaurantInfo"))
                .andExpect(MockMvcResultMatchers.model().attribute("restaurantInfo", restaurantInfo))
                .andExpect(MockMvcResultMatchers.view().name("restaurantInfo"));
    }

    // Тестирование метода updateRestaurantInfo
    @Test
    public void testUpdateRestaurantInfo() throws Exception {
        // Создание объекта RestaurantInfo для обновления
        RestaurantInfo restaurantInfo = new RestaurantInfo();
        restaurantInfo.setAdminId(1L); // Пример ID администратора
        restaurantInfo.setName("Updated Name");
        restaurantInfo.setAddress("Updated Address");

        // Мокирование вызова репозитория для сохранения информации о ресторане
        when(restaurantRepo.save(any(RestaurantInfo.class))).thenReturn(restaurantInfo);

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.post("/restaurant/update")
                        .flashAttr("restaurantInfo", restaurantInfo))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/restaurant/info"));
    }
}
import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.MediaType;
        import org.springframework.mock.web.MockHttpServletResponse;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import static org.mockito.Mockito.when;
        import static org.mockito.Mockito.anyLong;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderRepository orderRepo;

    @Mock
    private PdfService pdfService;

    @InjectMocks
    private OrderController orderController;

    // Тестирование метода viewOrderStats
    @Test
    public void testViewOrderStats() throws Exception {
        // Подготовка данных для запроса
        OrderStats orderStats = new OrderStats(); // Замените на реальный класс статистики заказов
        // ... инициализация данных статистики заказов ...

        // Мокирование вызова репозитория для возврата статистики заказов
        when(orderRepo.findOrderStatsByRestaurantId(anyLong())).thenReturn(orderStats);

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/stats"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("orderStats"))
                .andExpect(MockMvcResultMatchers.model().attribute("orderStats", orderStats))
                .andExpect(MockMvcResultMatchers.view().name("orderStats"));
    }

    // Тестирование метода downloadOrderStatsPdf
    @Test
    public void testDownloadOrderStatsPdf() throws Exception {
        // Подготовка данных для запроса
        byte[] pdfContent = new byte[]{1, 2, 3, 4}; // Пример содержимого PDF

        // Мокирование вызова сервиса для создания PDF
        when(pdfService.createOrderStatsPdf(anyLong())).thenReturn(pdfContent);

        // Выполнение запроса и проверка результата
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/orders/stats/pdf"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_PDF))
                .andReturn().getResponse();

        // Проверка содержимого ответа
        assertArrayEquals(pdfContent, response.getContentAsByteArray());
    }
}
import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import
        org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.MediaType;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testFioProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/fio")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("fio", "Test FIO"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }
    @Test
    public void testTelProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tel")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("tel", "1234567890"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }
    @Test
    public void testEmailProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/email")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }}
import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import
        org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.MediaType;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testFioProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/fio")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("fio", "Test FIO"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }
    @Test
    public void testTelProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tel")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("tel", "1234567890"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }
    @Test
    public void testEmailProfile() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/email")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("email", "test@example.com"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/profile"));
    }}

import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.http.MediaType;
        import org.springframework.mock.web.MockHttpServletResponse;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import static org.mockito.Mockito.when;
        import static org.mockito.Mockito.anyList;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantStatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderRepository orderRepo;

    @Mock
    private PdfService pdfService;

    @InjectMocks
    private RestaurantController restaurantController;

    // Тестирование метода viewSelectedRestaurantsStats
    @Test
    public void testViewSelectedRestaurantsStats() throws Exception {
        // Подготовка данных для запроса
        List<RestaurantStats> selectedRestaurantsStats = ...; // Замените на реальный класс статистики ресторанов и данные

        // Мокирование вызова репозитория для возврата статистики выбранных ресторанов
        when(orderRepo.findStatsByRestaurantIds(anyList())).thenReturn(selectedRestaurantsStats);

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/stats")
                        .param("restaurantIds", "1", "2", "3")) // Пример ID ресторанов
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("selectedRestaurantsStats"))
                .andExpect(MockMvcResultMatchers.model().attribute("selectedRestaurantsStats", selectedRestaurantsStats))
                .andExpect(MockMvcResultMatchers.view().name("selectedRestaurantsStats"));
    }

    // Тестирование метода downloadSelectedRestaurantsStatsPdf
    @Test
    public void testDownloadSelectedRestaurantsStatsPdf() throws Exception {
        // Подготовка данных для запроса
        byte[] pdfContent = ...; // Пример содержимого PDF

        // Мокирование вызова сервиса для создания PDF
        when(pdfService.createSelectedRestaurantsStatsPdf(anyList())).thenReturn(pdfContent);

        // Выполнение запроса и проверка результата
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/stats/pdf")
                        .param("restaurantIds", "1", "2", "3")) // Пример ID ресторанов
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_PDF))
                .andReturn().getResponse();

        // Проверка содержимого ответа
        assertArrayEquals(pdfContent, response.getContentAsByteArray());
    }
}
import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import static org.mockito.Mockito.when;
        import static org.mockito.Mockito.verify;
        import static org.mockito.Mockito.times;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepo;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    // Тестирование метода getUsers
    @Test
    public void testGetUsers() throws Exception {
        // Подготовка данных для запроса
        List<User> users = Arrays.asList(
                new User("John Doe", Role.USER),
                new User("Jane Smith", Role.USER)
        );

        // Мокирование вызова репозитория для возврата списка пользователей
        when(userRepo.findAll()).thenReturn(users);

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("users"))
                .andExpect(MockMvcResultMatchers.model().attribute("users", users))
                .andExpect(MockMvcResultMatchers.view().name("users"));
    }

    // Тестирование метода blockUser
    @Test
    public void testBlockUser() throws Exception {
        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/users/block/1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/users"));

        // Проверка, что метод blockUser был вызван
        verify(userService, times(1)).blockUser(1L);
    }

    // Тестирование метода unblockUser
    @Test
    public void testUnblockUser() throws Exception {
        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.get("/users/unblock/1"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/users"));

        // Проверка, что метод unblockUser был вызван
        verify(userService, times(1)).unblockUser(1L);
    }
}

import org.junit.jupiter.api.Test;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import org.springframework.ui.Model;
        import static org.mockito.Mockito.when;
        import static org.mockito.Mockito.any;
        import static org.mockito.Mockito.anyLong;
        import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderRepository orderRepo;

    @InjectMocks
    private OrderAdminController orderAdminController;

    // Тестирование метода approveOrder
    @Test
    public void testApproveOrder() throws Exception {
        // Подготовка данных для запроса
        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.NEW); // Предполагаем, что статус заказа изначально NEW

        // Мокирование вызова репозитория для возврата заказа
        when(orderRepo.findById(eq(1L))).thenReturn(java.util.Optional.of(order));

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/approveOrder")
                        .param("orderId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.model().attribute("message", "Заказ одобрен"))
                .andExpect(MockMvcResultMatchers.view().name("orderResponse"));
    }

    // Тестирование метода rejectOrder
    @Test
    public void testRejectOrder() throws Exception {
        // Подготовка данных для запроса
        Order order = new Order();
        order.setId(1L);
        order.setStatus(OrderStatus.NEW); // Предполагаем, что статус заказа изначально NEW

        // Мокирование вызова репозитория для возврата заказа
        when(orderRepo.findById(eq(1L))).thenReturn(java.util.Optional.of(order));

        // Выполнение запроса и проверка результата
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/rejectOrder")
                        .param("orderId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.model().attribute("message", "Заказ отклонен"))
                .andExpect(MockMvcResultMatchers.view().name("orderResponse"));
    }
}
