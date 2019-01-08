import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppareilComponent} from './appareil/appareil.component';
import {AppareilService} from './service/appareil.service';
import {AuthComponent} from './auth/auth.component';
import {AppareilViewComponent} from './appareil-view/appareil-view.component';
import {RouterModule, Routes} from '@angular/router';
import {AuthService} from './service/auth.service';
import {SingleAppareilComponent} from './single-appareil/single-appareil.component';
import {FourOhFourErreurComponent} from './four-oh-four-erreur/four-oh-four-erreur.component';
import {AuthGuardService} from './service/auth.guard.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { UserFormComponent } from './user-form/user-form.component';


const appRoutes: Routes = [
  {path: 'appareils', canActivate: [AuthGuardService], component: AppareilViewComponent},
  {path: 'auth', component: AuthComponent},
  {path: '', component: AppareilViewComponent},
  {path: 'appareils/:id', canActivate: [AuthGuardService], component: SingleAppareilComponent},
  {path: 'user', component: UserFormComponent},
  {path: 'not-found', component: FourOhFourErreurComponent},
  // Il est essentiel le path wilcard ** à la fin car si angular va regarder chaque route dans l'ordre'
  {path: '**', redirectTo: '/not-found'}
];

@NgModule({
  declarations: [
    AppComponent,
    AppareilComponent,
    AuthComponent,
    AppareilViewComponent,
    SingleAppareilComponent,
    FourOhFourErreurComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes), // en gros toutes les routes qu'on veut rengistrer ce trouve dans ce constante
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    AppareilService,
    AuthService,
    AuthGuardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
