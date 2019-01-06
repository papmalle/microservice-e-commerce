import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Appareil} from '../appareil/appareil';
import {map, throttleTime} from 'rxjs/operators';

@Injectable()
export class AppareilService {

  private appareils: Appareil[];

  constructor(private callHttp: HttpClient) {

  }

  getListAppareils(): Observable<Appareil[]> {
    if (this.appareils) return of(this.appareils);

    return this.callHttp.get<Appareil[]>('http://localhost:8080/appareils').pipe(
      // throttleTime(5000)
      map(((value, index) => this.appareils = value))
    );
  }

  getAppareilById(id: number) {
    return this.appareils.find(
      (app) => {
        return app.id === id;
      }
    );
  }

  switchOnAll() {
    this.appareils.forEach(function (app) {
      app.status = 'allumer';
    });
  }

  switchOffAll() {
    for (let appareil of this.appareils) {
      appareil.status = 'eteint';
    }
  }

  swicthOnOne(index: number) {
    this.appareils[index].status = 'allumer';
  }

  swicthOffOne(index: number) {
    this.appareils[index].status = 'eteint';
  }


}
