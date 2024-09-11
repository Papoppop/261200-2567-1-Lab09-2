package th.ac.cmu.cpe.oop.patterns.adapter.site;
import th.ac.cmu.cpe.oop.patterns.adapter.payd.PayD;
import th.ac.cmu.cpe.oop.patterns.adapter.xpay.Xpay;

public class Main {
    public static void main(String[] args) {
        Xpay xpay = new XpayImpl();
        xpay.setCreditCardNo("4789565874102365");
        xpay.setCustomerName("Champoo CGM48");
        xpay.setCardExpMonth("09");
        xpay.setCardExpYear("25");
        xpay.setCardCVVNo((short) 235);
        xpay.setAmount(2565.23);
        PayD payD = new XpayToPayDAdapter(xpay);

        System.out.println(payD.getCardOwnerName());
        System.out.println(payD.getCreditCardNo());
        System.out.println(payD.getCardExpMonthYear());
        System.out.println("Current CVV: " + payD.getCVVNo());
        payD.setCVVNo(999); //Changed the CVV No.
        System.out.println("Changed CVV: " + payD.getCVVNo());

    }
}
