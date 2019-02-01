import {AccountUser} from "./Account.model";
import {Adresse} from "./Adresse.model";

export class User {


  // c'est un racourcis typeScripte en utilisant public il va creer automatique les proprietés de chaque champs
  // public books?: String[] avec ? est une option
  constructor(public firstName: String,
              public lastName: String,
              public email: String,
              public password: String,
              public accountDtos: AccountUser[],
              public adresseDto: Adresse,
              public books?: String[]) {
  }
}
