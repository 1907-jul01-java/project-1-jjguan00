import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-frontpage',
    templateUrl: './frontpage.component.html',
    styleUrls: ['./frontpage.component.css']
})
export class FrontpageComponent implements OnInit {
    user: any = {};
    constructor(
        private userservice: UserService,
        private router: Router,
        private activatedrouter: ActivatedRoute) { this.user = this.activatedrouter.snapshot.queryParams }

    ngOnInit() {
        console.log(this.user);
    }

    checkLogIn() {
        if (this.user.name == false) {
            return this.router.navigate['/'];
        }
    }

    logOut(): boolean {
        this.user = {};
        console.log("here");
        this.router.navigate(['/']);
        return true;
    }

}
