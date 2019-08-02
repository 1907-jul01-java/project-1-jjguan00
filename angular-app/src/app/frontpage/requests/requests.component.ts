import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReimbursementService } from './../../reimbursement.service';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
    requests: any = {};
    user = '';
  constructor(private reimbursementservice: ReimbursementService, private router: Router, private activatedroute: ActivatedRoute) {

    }

  ngOnInit() {
      this.user = this.activatedroute.snapshot.params.data;
      console.log( this.user);
      this.getbyuser();
  }

      getbyuser() {
        return this.reimbursementservice.getbyuser(this.user).subscribe(data => {
            this.requests = data
            console.log(data)
        })
    }

}
