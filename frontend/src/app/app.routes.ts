import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { App } from './app';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'app', component: App },
];
