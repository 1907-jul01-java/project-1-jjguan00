import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  request(submitrequest: {}) {
      console.log(submitrequest);
      return this.http.post('/project-1-jjguan00/api/reimbursement/request', submitrequest);
  }

  getall() {
      return this.http.get('/project-1-jjguan00/api/reimbursement/getall');
  }

  deny(id: number) {
      console.log(id);
    return this.http.get(`/project-1-jjguan00/api/reimbursement/deny/${id}`);
  }

    approve(id: number) {
      console.log(id);
    return this.http.get(`/project-1-jjguan00/api/reimbursement/approve/${id}`);
  }

    destroy(id: number) {
      console.log(id);
    return this.http.get(`/project-1-jjguan00/api/reimbursement/destroy/${id}`);
  }
}
