package studAdmin;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class EncryptPassword {

    public byte[] encrypt(String password, byte[] salt) {
        int iterations = 10000;
        int keyLength = 512;
        char[] passwordChars = password.toCharArray();

        return hashPassword(passwordChars, salt, iterations, keyLength);
    }

    public byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltArr = new byte[64];
        random.nextBytes(saltArr);
        return saltArr;
    }

    private byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
