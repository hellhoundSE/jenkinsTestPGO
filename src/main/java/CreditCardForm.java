import java.time.LocalDate;
import java.util.ArrayList;

class CreditCardForm {

    private static final ArrayList<Integer> EXPIRATION_YEARS = new ArrayList<>();
    private String number;
    private int cvc;
    private int expirationYear;

    static {
        int currentYear = getCurrentYear();
        for (int i = currentYear; i <= currentYear + 20; i++) {
            EXPIRATION_YEARS.add(i);
        }
    }

    public CreditCardForm(String number, int cvc) {
        this.number = number;
        this.cvc = cvc;
        this.expirationYear = RandomNumbers.nextIntFromRange(EXPIRATION_YEARS.get(0),
                EXPIRATION_YEARS.get(EXPIRATION_YEARS.size() - 1));
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    private static int getCurrentYear() {
        return LocalDate.now().getYear();
    }
}
