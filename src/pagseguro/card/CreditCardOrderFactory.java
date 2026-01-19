package pagseguro.card;

import java.util.List;
import java.util.Map;

/**
 * Factory responsible for building CreditCardOrderData instances.
 * Contains no encryption logic and no HTTP concerns.
 */
public final class CreditCardOrderFactory {

    private CreditCardOrderFactory() {
    }

    /**
     * Creates a mocked credit card order for local testing.
     */
    public static CreditCardOrderData createMockOrder(String encryptedCard) {

        CreditCardOrderData.Customer customer =
                new CreditCardOrderData.Customer(
                        "John Doe",
                        "john.doe@email.com",
                        "12345678909",
                        List.of(
                                new CreditCardOrderData.Phone(
                                        "55",
                                        "11",
                                        "999999999",
                                        "MOBILE"
                                )
                        )
                );

        CreditCardOrderData.Item item =
                new CreditCardOrderData.Item(
                        "ITEM-001",
                        "Notebook",
                        1,
                        750_000 // R$ 7.500,00 in cents
                );

        CreditCardOrderData.Card card =
                new CreditCardOrderData.Card(
                        encryptedCard,
                        false
                );

        CreditCardOrderData.PaymentMethod paymentMethod =
                new CreditCardOrderData.PaymentMethod(
                        "CREDIT_CARD",
                        1,
                        true,
                        card,
                        new CreditCardOrderData.Holder(
                                "John Doe",
                                "12345678909"
                        )
                );

        CreditCardOrderData.Charge charge =
                new CreditCardOrderData.Charge(
                        "CHARGE-001",
                        "Notebook purchase",
                        new CreditCardOrderData.Amount(
                                750_000,
                                "BRL"
                        ),
                        paymentMethod
                );

        return new CreditCardOrderData(
                "ORDER-CC-123",
                customer,
                List.of(item),
                null, // optional
                List.of("https://example.com/webhook"),
                List.of(charge),
                Map.of("source", "local-test")
        );
    }
}

