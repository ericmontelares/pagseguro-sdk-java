package pagseguro.card;

import java.util.List;
import java.util.Map;

public class CreditCardOrderData {

    private String referenceId;
    private Customer customer;
    private List<Item> items;
    private Shipping shipping;
    private List<String> notificationUrls;
    private List<Charge> charges;
    private Map<String, String> metadata;

    public CreditCardOrderData() {}

    public CreditCardOrderData(
            String referenceId,
            Customer customer,
            List<Item> items,
            Shipping shipping,
            List<String> notificationUrls,
            List<Charge> charges,
            Map<String, String> metadata
    ) {
        this.referenceId = referenceId;
        this.customer = customer;
        this.items = items;
        this.shipping = shipping;
        this.notificationUrls = notificationUrls;
        this.charges = charges;
        this.metadata = metadata;
    }

    public String getReferenceId() { return referenceId; }
    public Customer getCustomer() { return customer; }
    public List<Item> getItems() { return items; }
    public Shipping getShipping() { return shipping; }
    public List<String> getNotificationUrls() { return notificationUrls; }
    public List<Charge> getCharges() { return charges; }
    public Map<String, String> getMetadata() { return metadata; }

    public static class Customer {
        private String name;
        private String email;
        private String taxId;
        private List<Phone> phones;

        public Customer() {}

        public Customer(String name, String email, String taxId, List<Phone> phones) {
            this.name = name;
            this.email = email;
            this.taxId = taxId;
            this.phones = phones;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getTaxId() { return taxId; }
        public List<Phone> getPhones() { return phones; }
    }

    public static class Phone {
        private String country;
        private String area;
        private String number;
        private String type;

        public Phone() {}

        public Phone(String country, String area, String number, String type) {
            this.country = country;
            this.area = area;
            this.number = number;
            this.type = type;
        }

        public String getCountry() { return country; }
        public String getArea() { return area; }
        public String getNumber() { return number; }
        public String getType() { return type; }
    }

    public static class Item {
        private String referenceId;
        private String name;
        private int quantity;
        private long unitAmount; // cents

        public Item() {}

        public Item(String referenceId, String name, int quantity, long unitAmount) {
            this.referenceId = referenceId;
            this.name = name;
            this.quantity = quantity;
            this.unitAmount = unitAmount;
        }

        public String getReferenceId() { return referenceId; }
        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public long getUnitAmount() { return unitAmount; }
    }

    public static class Shipping {
        private Address address;

        public Shipping() {}

        public Shipping(Address address) {
            this.address = address;
        }

        public Address getAddress() { return address; }
    }

    public static class Address {
        private String street;
        private String number;
        private String complement;
        private String locality;
        private String city;
        private String regionCode;
        private String country;
        private String postalCode;

        public Address() {}

        public Address(
                String street,
                String number,
                String complement,
                String locality,
                String city,
                String regionCode,
                String country,
                String postalCode
        ) {
            this.street = street;
            this.number = number;
            this.complement = complement;
            this.locality = locality;
            this.city = city;
            this.regionCode = regionCode;
            this.country = country;
            this.postalCode = postalCode;
        }

        public String getStreet() { return street; }
        public String getNumber() { return number; }
        public String getComplement() { return complement; }
        public String getLocality() { return locality; }
        public String getCity() { return city; }
        public String getRegionCode() { return regionCode; }
        public String getCountry() { return country; }
        public String getPostalCode() { return postalCode; }
    }

    public static class Charge {
        private String referenceId;
        private String description;
        private Amount amount;
        private PaymentMethod paymentMethod;

        public Charge() {}

        public Charge(
                String referenceId,
                String description,
                Amount amount,
                PaymentMethod paymentMethod
        ) {
            this.referenceId = referenceId;
            this.description = description;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
        }

        public String getReferenceId() { return referenceId; }
        public String getDescription() { return description; }
        public Amount getAmount() { return amount; }
        public PaymentMethod getPaymentMethod() { return paymentMethod; }
    }

    public static class Amount {
        private long value;
        private String currency;

        public Amount() {}

        public Amount(long value, String currency) {
            this.value = value;
            this.currency = currency;
        }

        public long getValue() { return value; }
        public String getCurrency() { return currency; }
    }

    public static class PaymentMethod {
        private String type;
        private int installments;
        private boolean capture;
        private Card card;
        private Holder holder;

        public PaymentMethod() {}

        public PaymentMethod(
                String type,
                int installments,
                boolean capture,
                Card card,
                Holder holder
        ) {
            this.type = type;
            this.installments = installments;
            this.capture = capture;
            this.card = card;
            this.holder = holder;
        }

        public String getType() { return type; }
        public int getInstallments() { return installments; }
        public boolean isCapture() { return capture; }
        public Card getCard() { return card; }
        public Holder getHolder() { return holder; }
    }

    public static class Card {
        private String encrypted;
        private boolean store;

        public Card() {}

        public Card(String encrypted, boolean store) {
            this.encrypted = encrypted;
            this.store = store;
        }

        public String getEncrypted() { return encrypted; }
        public boolean isStore() { return store; }
    }

    public static class Holder {
        private String name;
        private String taxId;

        public Holder() {}

        public Holder(String name, String taxId) {
            this.name = name;
            this.taxId = taxId;
        }

        public String getName() { return name; }
        public String getTaxId() { return taxId; }
    }
}
