package pt.uma.tpsi;

import java.security.KeyStore;

public class NumericalUtiities {

    public static int powerOf(int base, int exp) {
        int res = 1;
        for (int i = 0; i < exp ; i++) {
            res *= base;
        }
        return res;
    }

    public static int  sumOfNaturalNumbersUpTo(int n) {
        int res = 0;
        for (int i = 0; i < n ; i++) {
            res += i;
        }
        return res;
    }

    public static int  sumOfNaturalNumbersBetween(int x, int y) {
        int res = 0;
        for (int i = x; i < y ; i++) {
            res += i;
        }
        return res;
    }

    public static int  sumOfEvenNumbersBetween(int x, int y) {
        int res = 0;
        for (int i = x; i < y ; i++) {
            if (i%2 == 0){
                res += i;
            }
        }
        return res;
    }

    public static int  numberOfDivisorsOf(int n) {
        int total = 0;
        for (int i = 1; i <= n ; i++) {
            if (n%i == 0){
                total+=1;
            }
        }
        return total;
    }

    /*public static char  isPrime(int n) {
        char result = 'N';
        if (n%2 != 0){
            result = 'S';
            return result;
        }
        return result;
    }*/

    public static boolean  isPrime(int n) {
        if (numberOfDivisorsOf(n) == 2){
          return true;
        }
        return false;
    }





}
