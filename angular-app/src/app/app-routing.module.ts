import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './home/login/login.component';
import { SignupComponent } from './home/signup/signup.component';


const routes: Routes = [{
    path: '', component: HomeComponent,
    children: [{path: 'login', component: LoginComponent}, {path: 'signup', component: SignupComponent}]
}
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
