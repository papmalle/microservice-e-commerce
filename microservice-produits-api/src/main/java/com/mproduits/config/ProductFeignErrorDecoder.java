package com.mproduits.config;

import com.mproduits.exception.ProductNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

/*
    Par defaut  feign renvoie systematiquement une erreur Http generique 500
    à chaque fois que le code https envoie est different de 200 jusqu'à 299
    Enfin de generer notre propre exception il va falloir decoder cette erreur feign
 */
public class ProductFeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default(); // Decodeur par defaut de feign

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            return new ProductNotFoundException("Produit non trouvé Yess OK");
        }
        // sinon envoie à errorDecoder par defaut de feign
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
