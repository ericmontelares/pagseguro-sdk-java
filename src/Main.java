import pagseguro.card.CardData;
import pagseguro.card.security.CardEncryption;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CardData card = new CardData(
                "4111111111111111",
                "123",
                "12",
                "2025",
                "John Doe",
                "MIIBIjANBgkq..."
        );

        Map<String, Object> result = CardEncryption.encrypt(card);

        if ((Boolean) result.get("hasErrors")) {
            System.out.println("Encryption failed: " + result.get("errors"));
        } else {
            System.out.println("Encrypted card: " + result.get("encryptedCard"));
        }
    }
}