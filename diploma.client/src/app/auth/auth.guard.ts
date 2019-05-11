import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {LoginService} from "../login/login.service";
import {LanguagesService} from "../shared/languages.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private login: LoginService,
              public languagesService: LanguagesService) {

  }


  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {


    if (!this.login.personDisplay || !this.login.personDisplay.cans.length) {
      return false
    }

    if (this.languagesService.languages.admin.indexOf(next.url) !== -1) {
      for (var key in this.login.personDisplay.cans) {
        if (this.login.canViewAdmin) {
          return true
        }
      }
      return false;
    }
    return true
  }

}
