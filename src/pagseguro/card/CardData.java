package pagseguro.card;

public class CardData {
    private String number;
    private String securityCode;
    private String expMonth;
    private String expYear;
    private String holder;
    private String publicKey;

    public CardData() {}

    public CardData(String number, String securityCode, String expMonth, String expYear, String holder, String publicKey) {
        this.number = number;
        this.securityCode = securityCode;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.holder = holder;
        this.publicKey = publicKey;
    }

    // Getters and setters
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getSecurityCode() { return securityCode; }
    public void setSecurityCode(String securityCode) { this.securityCode = securityCode; }

    public String getExpMonth() { return expMonth; }
    public void setExpMonth(String expMonth) { this.expMonth = expMonth; }

    public String getExpYear() { return expYear; }
    public void setExpYear(String expYear) { this.expYear = expYear; }

    public String getHolder() { return holder; }
    public void setHolder(String holder) { this.holder = holder; }

    public String getPublicKey() { return publicKey; }
    public void setPublicKey(String publicKey) { this.publicKey = publicKey; }
}
