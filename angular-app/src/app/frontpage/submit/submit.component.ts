import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { ReimbursementService } from './../../reimbursement.service';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {
  submiterequest: any = {};
  user: string = this.activateroute.snapshot.params.username;

  constructor(private reimbursementservice: ReimbursementService, private router: Router, private activateroute: ActivatedRoute) {}

  ngOnInit() {
        console.log('here');
        console.log(this.activateroute.snapshot.params.username);
  }

  request() {
      }

}
