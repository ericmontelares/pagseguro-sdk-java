package pagseguro.card.security;

import pagseguro.card.CardData;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class CardEncryption {

    public static Map<String, Object> encrypt(CardData cardData) {
        try {
            PublicKey publicKey = getPublicKeyFromString(cardData.getPublicKey());

            String dataToEncrypt = String.format("%s;%s;%s;%s;%s;%d",
                    cardData.getNumber(),
                    cardData.getSecurityCode(),
                    cardData.getExpMonth(),
                    cardData.getExpYear(),
                    cardData.getHolder(),
                    System.currentTimeMillis()
            );

            String encrypted = encryptWithRSA(publicKey, dataToEncrypt);

            return Map.of(
                    "hasErrors", false,
                    "errors", List.of(),
                    "encryptedCard", encrypted
            );
        } catch (Exception e) {
            return Map.of(
                    "hasErrors", true,
                    "errors", List.of("ENCRYPTION_ERROR: " + e.getMessage()),
                    "encryptedCard", null
            );
        }
    }

    private static PublicKey getPublicKeyFromString(String publicKeyStr) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePublic(keySpec);
    }

    private static String encryptWithRSA(PublicKey publicKey, String data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
