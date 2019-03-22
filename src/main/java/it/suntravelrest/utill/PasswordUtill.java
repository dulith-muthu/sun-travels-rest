package it.suntravelrest.utill;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordUtill
{
    public static String getHash(String text){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        }
        catch( NoSuchAlgorithmException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Takes user passphrase and append random salt with a number
     * appends it front to passphrase and encrypt new passphrase
     * @param passphrase passphrase from user
     * @return String[salt, encrypted salted passphrase]
     */
    public static String[] createPassword(String passphrase){
        String[] result = new String[2];
        String password;
        try{
            result[0] = Integer.toString( new Random().nextInt(100000));
            System.out.println("Salt " + result[0]);
            passphrase += result[0];
            System.out.println("Password with Salt " + passphrase);
            result[1] = getHash( passphrase );
            System.out.println("Encrypted Password " + result[1]);
            return result;
        }catch( Exception ex){
            //TODO:ADD error logs
            return null;
        }
    }
}
