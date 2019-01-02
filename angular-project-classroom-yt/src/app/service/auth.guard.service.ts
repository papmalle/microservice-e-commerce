import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';
import {AuthService} from './auth.service';

// pour injecter un service dans un autre service il faut utiliser le decorateur @Injectable()
@Injectable()
export class AuthGuardService implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // Si jamais l'utilisateur est connecté on retourne true et on le laisse passer
    if (this.authService.isAuth) {
      return true;
    } else {
      this.route.navigate(['/auth']); // on ne laisse pas passer et on le redirige vers la page d'authentification
      return false; // sinon on ne laissse pas passer
    }
  }

  constructor(private authService: AuthService, private route: Router) {

  }


}
