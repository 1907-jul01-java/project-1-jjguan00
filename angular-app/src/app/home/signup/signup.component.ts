import { Component, OnInit } from '@angular/core';
import { UserService } from '../../user.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
    user: any = {};

    constructor(private userservice: UserService, private router: Router) { }

    ngOnInit() {
    }

    create() {
        this.userservice.create(this.user).subscribe(() => this.router.navigate(['/']));
    }

}
