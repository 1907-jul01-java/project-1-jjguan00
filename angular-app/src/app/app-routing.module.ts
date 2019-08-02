import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './home/login/login.component';
import { SignupComponent } from './home/signup/signup.component';
import { FrontpageComponent } from './frontpage/frontpage.component';
import { SubmitComponent } from './frontpage/submit/submit.component';
import { RequestsComponent } from './frontpage/requests/requests.component';
import { AdminComponent } from './frontpage/admin/admin.component'

const routes: Routes = [{
    path: '', component: HomeComponent,
    children: [{ path: 'login', component: LoginComponent }, { path: 'signup', component: SignupComponent }]
}, {
    path: 'frontpage', component: FrontpageComponent,
    children: [{ path: 'requests', component: RequestsComponent }, { path: 'submit', component: SubmitComponent }, { path: 'admin', component: AdminComponent }]
}
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
