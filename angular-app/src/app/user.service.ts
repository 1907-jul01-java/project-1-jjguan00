import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
	providedIn: 'root'
})
export class UserService {

	constructor(private http: HttpClient) { }

	create(user: {}) {
		console.log(user);
		return this.http.post('/project-1-jjguan00/api/user/signup', user);
	}

	login(luser: {}) {
		console.log(luser);	
		return this.http.post('/project-1-jjguan00/api/user/login', luser);
	}
}
