import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestManager {
    public static void main(String[] args){

        InterestManager manager = new InterestManager();

        for(int i=0; i <= 370; i+=10){
            if(i>365) i = 365;
            System.out.println(i +": "+ manager.calculateAmout(i, 100));
        }
    }

    public BigDecimal getinterestRate(int day){
        
        BigDecimal rate;

        if(day <= 90){
            rate = new BigDecimal("0.5");    
        }
        else if(day <= 180){
            rate = new BigDecimal("1.0");
        }
        else if(day <= 364){
            rate = new BigDecimal("2.0");
        }
        else{
            rate = new BigDecimal("5.6");
        }

        return rate;
    }

    public BigDecimal calculateAmout(int day, long amount){

        BigDecimal rate = getinterestRate(day);
        BigDecimal principal = BigDecimal.valueOf(amount);
        BigDecimal hundred = new BigDecimal("100");

        BigDecimal ratePerOne = rate.divide(hundred);
        BigDecimal multiplier = BigDecimal.ONE.add(ratePerOne);
        BigDecimal result = principal.multiply(multiplier);

        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
