package interviewQuestions.glovo;

import java.math.BigInteger;

public class BionomialOptimized {

    static BigInteger binomialCoeff(BigInteger n, BigInteger k) {

        if (k.equals(BigInteger.ZERO) || k.equals(n))
            return BigInteger.ONE;

        return binomialCoeff(n.subtract(BigInteger.ONE), k.subtract(BigInteger.ONE))
                .add(binomialCoeff((n.subtract(BigInteger.ONE)), k));
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int n = 40, k = 20;
        System.out.printf("Value of C(%d, %d) is %d ",
                n, k, binomialCoeff(BigInteger.valueOf(n), BigInteger.valueOf(k)));
    }
}
