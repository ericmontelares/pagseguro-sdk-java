import pagseguro.card.CardData;
import pagseguro.card.CardEncryption;
import pagseguro.card.CreditCardOrderData;
import pagseguro.card.CreditCardOrderFactory;
import pagseguro.order.OrderData;
import pagseguro.order.OrderFactory;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        CardData card = createCardData();

        String encryptedCard = encryptAndPrint(card);

        OrderData order = createAndPrintOrder();

        CreditCardOrderData creditOrder =
                createAndPrintCreditCardOrder(encryptedCard);
    }

    // -------- CARD --------
    private static CardData createCardData() {
        return new CardData(
                "4111111111111111",
                "123",
                "12",
                "2025",
                "John Doe",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArq9nJ5s9jH3NnJ8l+oV6z2FQrY6Wc1F3D0WJxU7H9p7LZBvU9gkG7jRk2x9zYF0v5C5QvZ7yQv1K8z1HcH2P9pQ7zW2yXbFzZ2Y5K9L7M9YJ8L5n4G6U7C1Q7E8R5M1P0G6Z5K1J8M4N6B3K2H7P9IDAQAB"
        );
    }

    private static String encryptAndPrint(CardData card) {
        System.out.println("=== CARD ENCRYPTION ===");

        Map<String, Object> result = CardEncryption.encrypt(card);

        if ((Boolean) result.get("hasErrors")) {
            System.out.println("❌ Encryption failed");
            System.out.println("❌ Errors: " + result.get("errors"));
            return null;
        }

        String encryptedCard = (String) result.get("encryptedCard");
        System.out.println("✅ Encrypted card: " + encryptedCard);
        return encryptedCard;
    }

    // -------- ORDER --------
    private static OrderData createAndPrintOrder() {
        System.out.println("\n=== ORDER DATA ===");

        OrderData order = OrderFactory.createMockOrder();

        System.out.println("✅ Reference ID: " + order.getReferenceId());
        System.out.println("✅ Customer: " + order.getCustomer().getName());

        return order;
    }

    // -------- CREDIT CARD ORDER --------
    private static CreditCardOrderData createAndPrintCreditCardOrder(String encryptedCard) {
        System.out.println("\n=== CREDIT CARD ORDER ===");

        CreditCardOrderData creditOrder =
                CreditCardOrderFactory.createMockOrder(encryptedCard);

        System.out.println("✅ Credit order created");
        System.out.println("✅ Reference ID: " + creditOrder.getReferenceId());

        return creditOrder;
    }
}