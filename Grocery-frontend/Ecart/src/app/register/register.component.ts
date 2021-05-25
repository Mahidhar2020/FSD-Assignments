import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MustMatch } from '../_helpers/validaters';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  constructor(private service:AppService,private router:Router,private formBuilder: FormBuilder) { }
 
  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      UserName: ['', [Validators.required,Validators.minLength(6)]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
  }, {
      validator: MustMatch('password', 'confirmPassword')
  });
  }

  get f() { return this.registerForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }
        else{
          const user={
            username:this.registerForm.controls.UserName.value === undefined || this.registerForm.controls.UserName.value === ''?null :this.registerForm.controls.UserName.value ,
      firstname:this.registerForm.controls.firstName.value === undefined || this.registerForm.controls.firstName.value === ''?null :this.registerForm.controls.firstName.value ,
      lastname:this.registerForm.controls.lastName.value === undefined || this.registerForm.controls.lastName.value === ''?null :this.registerForm.controls.lastName.value ,
      email:this.registerForm.controls.email.value === undefined || this.registerForm.controls.email.value === ''?null :this.registerForm.controls.email.value ,
      password:this.registerForm.controls.password.value === undefined || this.registerForm.controls.password.value === ''?null :this.registerForm.controls.password.value ,
      active:1,
      role:"user"
          };
          console.log(user);
          this.service.adduser(user);
        }
    }
}
