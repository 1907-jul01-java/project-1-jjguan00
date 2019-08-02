import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReimbursementService } from './../../reimbursement.service';

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.css']
})
export class SubmitComponent implements OnInit {
  submiterequest: any = {};
  user = '';

  constructor(private reimbursementservice: ReimbursementService, private router: Router, private activateroute: ActivatedRoute) {
      this.user = this.activateroute.snapshot.params.username;
  }

  ngOnInit() {
        this.user = this.activateroute.snapshot.params.username;
  }

  request() {
      this.submiterequest.username = this.activateroute.snapshot.params.data;
      this.submiterequest.status = 'pending' ;
      return this.reimbursementservice.request(this.submiterequest).subscribe(() => this.router.navigate(['/frontpage']));  
      }
}
