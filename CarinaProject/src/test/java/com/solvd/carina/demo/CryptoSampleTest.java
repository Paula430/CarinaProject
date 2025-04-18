package com.solvd.carina.demo;

import com.zebrunner.carina.crypto.Algorithm;
import com.zebrunner.carina.crypto.CryptoTool;
import com.zebrunner.carina.crypto.CryptoToolBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;

import static com.zebrunner.carina.crypto.Algorithm.AES_ECB_NO_PADDING;
import static com.zebrunner.carina.crypto.Algorithm.AES_ECB_PKCS5_PADDING;


/**
 * This sample shows how use Crypto in tests.
 *
 * @author qpsdemo
 */
public class CryptoSampleTest implements IAbstractTest {

    //private final String value= R.CONFIG.get("password");
//    String value=R.CONFIG.get("password");
//    private final String pattern="\\\\\\{crypt:(?<data>.+?)\\\\}";
//    private final Algorithm algorithm=AES_ECB_PKCS5_PADDING;
//    private final String key=R.CONFIG.get("crypto_key_value");

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
//        CryptoTool cryptoTool = CryptoToolBuilder.builder()
//                .chooseAlgorithm(algorithm)
//                .setKey(key)
//                .build();
//        String CRYPTO_PATTERN = pattern;
//        String decryptedValue = cryptoTool.decrypt(value,CRYPTO_PATTERN);
//        System.out.println("DEcryptes value:--------------------------------------------------------------------------------------------");
//        System.out.println(decryptedValue);
        Assert.assertEquals(R.TESTDATA.get("test_credentials"), "test@gmail.com/EncryptMe");
        //Assert.assertEquals(R.CONFIG.get("password"), "" );
    }

    @Test
    public void testEncryption() {
        Assert.assertEquals(R.CONFIG.get("password"), "EncryptMe");
    }

    @Test
    public void testPlaceholdersWithEncryption() {
        Assert.assertEquals(R.CONFIG.get("credentials"), "test@gmail.com/EncryptMe");
    }

}
