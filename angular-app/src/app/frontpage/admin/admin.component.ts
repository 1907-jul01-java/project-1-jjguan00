import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../reimbursement.service';
import {Router,ActivatedRoute} from '@angular/router';

@Component({
    selector: 'app-admin',
    templateUrl: './admin.component.html',
    styleUrls: ['./admin.component.css']
})


export class AdminComponent implements OnInit {
    requests: any = {};
    constructor(private reimbursementservice: ReimbursementService, private router: Router) { }

    ngOnInit() {
        this.getAll();
    }

    getAll() {
        return this.reimbursementservice.getall().subscribe(data => {
            this.requests = data
            console.log(this.requests)
        })
    }

    deny(number) {
        return this.reimbursementservice.deny(number).subscribe(() => this.router.navigate(['/frontpage']))
    }

    approve(number) {
        return this.reimbursementservice.approve(number).subscribe(() => this.router.navigate(['/frontpage']))
    }

    destroy(number) {
        return this.reimbursementservice.destroy(number).subscribe(() => this.router.navigate(['/frontpage']))
    }

}
