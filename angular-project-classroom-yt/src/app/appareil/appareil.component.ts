import {Component, Input, OnInit} from '@angular/core';
import {AppareilService} from '../service/appareil.service';

@Component({
  selector: 'app-appareil',
  templateUrl: './appareil.component.html',
  styleUrls: ['./appareil.component.scss']
})
export class AppareilComponent implements OnInit {
  @Input() appareilName: string;
  @Input() appareilStatus: string; // interpolation des données venant du typeScript et l'afficher dans le template

  @Input() indexOfAppareil: number;

  @Input() id: number;


  getStatus(): string {
    return this.appareilStatus;
  }

  constructor(private appareilService: AppareilService) {
  }


  ngOnInit() {
  }

  getColor(): string {
    return this.appareilStatus === 'eteint' ? 'red' : 'green';
  }

  onSwitchOn() {
    this.appareilService.swicthOnOne(this.indexOfAppareil);
  }

  offSwitchOn() {
    this.appareilService.swicthOffOne(this.indexOfAppareil);
  }
}
