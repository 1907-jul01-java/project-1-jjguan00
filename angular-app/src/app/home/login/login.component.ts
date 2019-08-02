import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    logInUser: any = {};
    constructor(private userservice: UserService,
        private router: Router) { }

    ngOnInit() {
    }

    login() {
        return this.userservice.login(this.logInUser).subscribe(result => {
            this.router.navigate(["/frontpage"], {queryParams: result});
        })
    }
}
