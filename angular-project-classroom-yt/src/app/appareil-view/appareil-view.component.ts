import {Component, OnInit} from '@angular/core';
import {AppareilService} from '../service/appareil.service';
import {Appareil} from '../appareil/appareil';

@Component({
  selector: 'app-appareil-view',
  templateUrl: './appareil-view.component.html',
  styleUrls: ['./appareil-view.component.scss']
})
export class AppareilViewComponent implements OnInit {
  isAuth = false;
  lastUpdate = new Promise((resolve, reject) => {
      const date = new Date();
      setTimeout(() => {
        resolve(date);
      }, 2000);
    }
  );
  appareils: any[];


  constructor(private appareilService: AppareilService) {
    setTimeout(() => {
      this.isAuth = true;
    }, 4000);
  }

  onAllumer() {
    this.appareilService.switchOnAll();
  }

  ngOnInit(): void {

    this.appareilService.getListAppareils().subscribe((value: Appareil[]) => {
        this.appareils = value;
      }, (error: any) => {
        console.log('il ya eu une erreur');
      },
      () => {
        console.log('Complete');
      });

    // this.appareilService.getListAppareils().subscribe(value => this.appareils = value);
  }

  onEteindre() {
    this.appareilService.switchOffAll();
  }

}
