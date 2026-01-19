package pagseguro.order;

import java.util.List;

public class OrderFactory {

    public static OrderData createMockOrder() {

        OrderData.Customer customer =
                new OrderData.Customer(
                        "John Doe",
                        "john.doe@email.com",
                        "12345678909",
                        List.of(
                                new OrderData.Phone("55", "11", "999999999", "MOBILE")
                        )
                );

        OrderData.Item item =
                new OrderData.Item("T-Shirt", 1, 5000);

        OrderData.QrCode qrCode =
                new OrderData.QrCode(
                        new OrderData.Amount(5000),
                        List.of("PIX"),
                        "2026-12-31T23:59:59-03:00"
                );

        OrderData.Address address =
                new OrderData.Address(
                        "Av Paulista",
                        "1000",
                        "Apt 101",
                        "Bela Vista",
                        "São Paulo",
                        "SP",
                        "BRA",
                        "01310100"
                );

        return new OrderData(
                "ORDER-123",
                customer,
                List.of(item),
                List.of(qrCode),
                new OrderData.Shipping(address),
                List.of("https://example.com/webhook")
        );
    }
}
