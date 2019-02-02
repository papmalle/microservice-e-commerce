import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../service/user.service";
import {User} from "../models/User.model";
import {Adresse} from "../models/Adresse.model";
import {AccountUser} from "../models/Account.model";

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.scss']
})
export class NewUserComponent implements OnInit {
  userForm: FormGroup;


  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.userForm = this.formBuilder.group({
      firstName: ['', Validators.required, Validators.minLength(6)],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      adresseName: ['', Validators.required],
      adresseCode: [0, Validators.required],
      books: this.formBuilder.array([])
      // accountDtos: this.formBuilder.array([this.createAccount()]),

    });
  }

/*  private createAccount(): FormGroup {
    return this.formBuilder.group({
      accountNumber: ''
    });
  }

  getAccounts() {
    return this.userForm.get('accountDtos') as FormArray;
  }*/

/*  onAddAccounts() {
    const newAccountControl = this.formBuilder.control('', Validators.required)
    this.getAccounts().push(newAccountControl);
  }*/


  getBooks() {
    return this.userForm.get('books') as FormArray;
  }

  onAddBooks() {
    const newBookControl = this.formBuilder.control('', Validators.required);
    this.getBooks().push(newBookControl);
  }


  onSubmitForm() {
    const formValue = this.userForm.value;

    const adresse = new Adresse(
      formValue['adresseName'],
      formValue['adresseCode']
    );

    // const accountUser = new AccountUser();


    const newUser = new User(
      formValue['firstName'],
      formValue['lastName'],
      formValue['email'],
      formValue['password'],
      [],
      adresse,
      formValue['books'] ? formValue['books'] : [] // Comme c'est une option , au cas c'est renseigné on retourne la valeur sinon une liste vide
    );

    this.userService.addUser(newUser);
    this.router.navigate(['/users']);
  }


}


