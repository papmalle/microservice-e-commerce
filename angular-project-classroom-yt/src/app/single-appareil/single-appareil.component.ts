import {Component, OnInit} from '@angular/core';
import {AppareilService} from '../service/appareil.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-single-appareil',
  templateUrl: './single-appareil.component.html',
  styleUrls: ['./single-appareil.component.scss']
})
export class SingleAppareilComponent implements OnInit {
  name: string;
  status: string;

  // Afin de recuperer le fragment id , il faudra injecter ActivatedRoute contient toutes les informations de la route active
  constructor(private appareilService: AppareilService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    // http://localhost:4200/appareils/ezqdfq alors  name = ezqdfq
    const id = this.route.snapshot.params['id'];
    // +id pour le caster le string en number car le this.route.snapshot.params['id'] retourne un string
    this.name = this.appareilService.getAppareilById(+id).name;
    this.status = this.appareilService.getAppareilById(+id).status;
  }

}
