package th.ac.cmu.cpe.oop.patterns.adapter.site;
import th.ac.cmu.cpe.oop.patterns.adapter.payd.PayD;
import th.ac.cmu.cpe.oop.patterns.adapter.xpay.Xpay;
public class XpayToPayDAdapter implements PayD {
    private final Xpay xpay;

    public XpayToPayDAdapter(Xpay xpay) {
        this.xpay = xpay;
    }

    @Override
    public String getCreditCardNo() {
        return this.xpay.getCreditCardNo();
    }

    @Override
    public String getCardOwnerName() {
        return this.xpay.getCustomerName();
    }

    @Override
    public String getCardExpMonthYear() {
        return this.xpay.getCardExpMonth() + this.xpay.getCardExpYear();
    }

    @Override
    public Integer getCVVNo() {
        return Integer.parseInt(String.valueOf(xpay.getCardCVVNo()));
    }

    @Override
    public Double getTotalAmount() {
        return xpay.getAmount();
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {
        xpay.setCreditCardNo(creditCardNo);
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        xpay.setCustomerName(cardOwnerName);
    }

    @Override
    public void setCardExpMonthYear(String cardExpMonthYear) {
        xpay.setCardExpMonth(cardExpMonthYear.substring(0, 2));
        xpay.setCardExpYear(cardExpMonthYear.substring(3, 2));

    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        xpay.setCardCVVNo(Short.parseShort(String.valueOf(cVVNo)));
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        xpay.setAmount(totalAmount);
    }
}
