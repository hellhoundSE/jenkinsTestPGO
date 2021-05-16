import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class TestCreditCardForm {

    @Test
    public void testNumberField(){
        GenericTestFactory.testFieldExists(CreditCardForm.class,"number");
        GenericTestFactory.testFieldType(CreditCardForm.class,"number",String.class);
        GenericTestFactory.testFieldModifier(CreditCardForm.class,"number", Modifier.STATIC);
    }
    @Test
    public void testCVCField(){
        GenericTestFactory.testFieldExists(CreditCardForm.class,"cvc");
        GenericTestFactory.testFieldType(CreditCardForm.class,"cvc",Integer.class,true);
        GenericTestFactory.testFieldModifier(CreditCardForm.class,"cvc", Modifier.PRIVATE);
    }
    @Test
    public void testExpirationYearField(){
        GenericTestFactory.testFieldExists(CreditCardForm.class,"expirationYear");
        GenericTestFactory.testFieldType(CreditCardForm.class,"expirationYear",Integer.class,true);
        GenericTestFactory.testFieldModifier(CreditCardForm.class,"expirationYear", Modifier.PRIVATE);
    }
    @Test
    public void testEXRIRATIO_YEARSField(){
        GenericTestFactory.testFieldExists(CreditCardForm.class,"EXPIRATION_YEARS");
        GenericTestFactory.testFieldType(CreditCardForm.class,"EXPIRATION_YEARS", ArrayList.class);
        GenericTestFactory.testFieldModifier(CreditCardForm.class,"EXPIRATION_YEARS", Modifier.PRIVATE+Modifier.STATIC);

        CreditCardForm ccf = GenericTestFactory.getInstance(CreditCardForm.class);
        ArrayList<Integer> years = GenericTestFactory.getField(ccf,"EXPIRATION_YEARS");

        if(years.size() != 20 && years.size() != 21){
            fail();
        }

        for (int i = LocalDate.now().getYear(); i < LocalDate.now().getYear() + 20; i++){
            if(!years.contains(i))
                fail();
        }
    }
    @Test
    public void testConstructor(){

        String number = "1234 1234 1234 1234";
        int cvc = 125;
        List<CreditCardForm> list = GenericTestFactory.getInstance(CreditCardForm.class, new Object[]{number,cvc},true);

        if(list.size() != 1)
            fail();

        CreditCardForm ccf = GenericTestFactory.getProperObject(list,new String[]{"number","cvc"},new Object[]{number,cvc});
        if(ccf == null)
            fail();

        int expYear = GenericTestFactory.getField(ccf,"expirationYear");
        ArrayList<Integer> years = GenericTestFactory.getField(ccf,"EXPIRATION_YEARS");

        if(!years.contains(expYear))
            fail();


    }


}
