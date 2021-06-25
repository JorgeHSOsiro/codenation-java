package challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        String lowerString = texto.toLowerCase();
        int textoSize = lowerString.length();
        for (int i = 0; i<=textoSize; i++) {
            char c = lowerString.charAt(i);
        }
        return texto;
    }

    @Override
    public String descriptografar(String texto) {
        throw new UnsupportedOperationException("esse method nao esta implementado aainda");
    }
}
