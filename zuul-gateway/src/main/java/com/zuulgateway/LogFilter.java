package com.zuulgateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class LogFilter extends ZuulFilter {
    @Autowired
    private HttpServletRequest httpServletRequest;

    // retourne "pre" si le filtre doit etre executé en entré du zuul sinon "pos" à la sortie de zuul
    @Override

    public String filterType() {
        return "pre";
    }

    // l'ordre du filtre s'il yen a plusieur à etre executé
    @Override
    public int filterOrder() {
        return 1;
    }

    // True or false si on doit executer le filtre ou pas
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // Ce qu'il faut faire une fois qu'on a intercepter la requete
    @Override
    public Object run() throws ZuulException {

        log.info("**** Requête interceptée ! L'URL est : {} " , httpServletRequest.getRequestURL());
        return null;
    }
}
/*


    Un filtre ZUUL est simplement une classe qui hérite de  ZuulFilter. Vous devez implémenter les 4 méthodes obligatoires.

        filterType  : cette méthode sert à déterminer le type de filtre à appliquer, elle propose 4 possibilités :
        pre : permet d'exécuter du code avant la redirection de la requête vers sa destination finale.
        post : permet d'exécuter du code après que la requête a été redirigée.
        route : permet d'agir sur la façon de rediriger les requêtes.
        error : permet d'agir en cas d'erreur lors de la redirection de la requête.

        filterOrder  : dans votre API Gateway ZUUL, vous aurez forcément des dizaines de filtres. Cette méthode détermine l'ordre d'exécution de ce filtre.

        shouldFilter  : permet d'écrire les conditions qui doivent être remplies pour que le filtre s'exécute.

        run  : c'est ici que va la logique de votre filtre*/
