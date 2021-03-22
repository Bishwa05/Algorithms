package array;

/**
 * Time complexity O(sqrt(n)).
 */
public class CheckPrimeNumber
{
    public boolean isPrime(int number){
        if(number < 2) return false;
        if(number == 2) return true;
        if(number %2 ==0) return true;

        for(int i =3; i*i <= number; i+=2) {
            if(number %i ==0) return false;
        }
        return true;
    }
}
