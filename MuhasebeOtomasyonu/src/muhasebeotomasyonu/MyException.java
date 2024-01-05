
package muhasebeotomasyonu;

/**
 *
 * @author azizn
 */
/**
 * Kendi özel istisna (exception) sınıfı olan MyException sınıfı.
 */
public class MyException extends Exception{

    /**
     * MyException sınıfının parametreli constructor metodu.
     * 
     * @param message İstisna mesajı
     */
    public MyException(String message) {
        super(message);
    }
}
