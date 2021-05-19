import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/Service/api.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient, HttpHeaders, HttpEvent, HttpRequest } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup
  error = false;
  constructor(private apiService: ApiService,
    private router: Router,private http:HttpClient,
    private formBuilder: FormBuilder) {
    this.createForm();
  }

  ngOnInit() {
  }
  createForm() {
    this.loginForm = this.formBuilder.group({
      email:[''],
      password:['']
    });
  }
  login(): void {
    const body ={
      'username':this.loginForm.controls.email.value,
      'password':this.loginForm.controls.password.value
    }
    console.log("log req",body)
    this.http.post('http://localhost:8080/home/auth',body).subscribe((res:any)=>{
      console.log(res)
    })
    this.apiService.login(body).
      subscribe(res => {
        if (res.status == "200" && res.userType == "CUSTOMER") {
          this.apiService.storeToken(res.authToken, "customer");
          this.router.navigate(['/home']);
          this.error = false;
        } else if (res.status == "200" && res.userType == "ADMIN") {
          this.apiService.storeToken(res.authToken, "admin");
          this.router.navigate(['/admin']);
          this.error = false;
        }
      },
        err => {
          this.router.navigate(['/login']);
      });
   }
}
