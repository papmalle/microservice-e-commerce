import {User} from "../models/User.model";
import {Observable, Subject} from "rxjs";
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable()
export class UserService {
  private usersBack: User[];
 private users: User[] = [
    {
      firstName: 'Jean',
      lastName: 'MALLE',
      email: 'jean.malle@gmail.com',
      password: '1234568',
      accountDtos: [
        {
          accountNumber: 'ACOUNT4568255'
        },
        {
          accountNumber: 'ACOUNT999965'
        }
      ],
      adresseDto: {
        name: 'Suresnes',
        codePostal: 92150
      },
      books: [
        'Book1',
        'Book2'
      ]

    }
  ];
  userSubject = new Subject<User[]>();

  constructor(private callHttp: HttpClient) {

  }


  emitUsers() {
    this.userSubject.next(this.users.slice()); // envoie juste la copie de la liste
  }

  addUser(user: User) {
    this.users.push(user);
    this.emitUsers();
    // this.callHttp.post<User>('http://localhost:8082/appareils', user);

  }



  getUsers(): Observable<User[]> {
    return this.callHttp.get<User[]>('http://localhost:9008/user').pipe(
      // throttleTime(5000)
      map(((value, index) => this.usersBack = value))
    );

  }

}
