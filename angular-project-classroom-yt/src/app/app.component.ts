import {Component, OnDestroy, OnInit} from '@angular/core';
import {interval, Subscription} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  secondes: number;
  countSubcription: Subscription; // Pour eviter tout les bug avec un counter infini on peut le detruire

  ngOnInit(): void {
    const counter = interval(1000);
    this.countSubcription = counter.subscribe((value: number) => {
      this.secondes = value;
    });

    /*count.subscribe(
      (value: number) => {
        this.secondes = value;
      },
      (error: any) => {
        console.log('Il ya une erreur');
      },
      () => {
        console.log('Complete !!');
      }
    )
    ;*/
  }

  ngOnDestroy(): void {
    console.log("componet destroy ");
    this.countSubcription.unsubscribe();
  }

}
