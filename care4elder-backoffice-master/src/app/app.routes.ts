import { Routes } from '@angular/router';
import { DashboardComponent } from './views/dashboard/dashboard.component';
import { LoginComponent } from './views/pages/login/login.component';
import { RegisterComponent } from './views/pages/register/register.component';
import { Page404Component } from './views/pages/page404/page404.component';
import { Page500Component } from './views/pages/page500/page500.component';
import { ReclamationListComponent } from './reclamation-list/reclamation-list.component'; // Correct the import if necessary
import { AddReclamationComponent } from './add-reclamation/add-reclamation.component';
import { ReclamationEditComponent } from './reclamation-edit/reclamation-edit.component';
import { DashboardReclamationComponent } from './dashboard-reclamation/dashboard-reclamation.component';
export const routes: Routes = [
  { path: 'dashboard', component: DashboardReclamationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '404', component: Page404Component },
  { path: '500', component: Page500Component },
  { path: 'admin/reclamations', component: ReclamationListComponent },
  { path: 'add-reclamation', component:AddReclamationComponent  },
  { path: 'reclamations/edit/:id', component:ReclamationEditComponent  },



  { path: '**', redirectTo: 'login' } 
];
