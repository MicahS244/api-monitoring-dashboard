import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import {ApiMonitoringService} from './services/api-monitoring.service';
import { Login } from './pages/login/login';
import { ApiService } from './models/api-service.model';
import { Incident } from './models/incident.model';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, Login],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  isLoggedIn = sessionStorage.getItem('isLoggedIn') === 'true';  
  services: ApiService[] = [];
  incidents: Incident[] = [];


  // Model for new incident form
  newIncident: Incident = {
    serviceName: '',
    title: '',
    severity: 'Medium',
    description: ''
  };

//Constructor injection of the ApiMonitoringService to be used for API calls
  constructor(private apiMonitoringService: ApiMonitoringService) {}

  ngOnInit(): void {
    this.isLoggedIn = sessionStorage.getItem('isLoggedIn') === 'true';

    if (this.isLoggedIn) {
      this.loadDashboardData();
    }
  }

  onLoginSuccess(): void {
    this.isLoggedIn = true;
    this.loadDashboardData();
  }

    logout(): void { 
     sessionStorage.removeItem('isLoggedIn');
     this.isLoggedIn = false;
   }

  loadDashboardData(): void {
    this.apiMonitoringService.getServices().subscribe({
      next: (data) => {
        this.services = data;
      },
      error: (error) => {
        console.error('Error loading services:', error);
      }
    });

    this.apiMonitoringService.getIncidents().subscribe({
      next: (data) => {
        this.incidents = data;
      },
      error: (error) => {
        console.error('Error loading incidents:', error);
      }
    });
  }

  createIncident(): void {
    if (!this.newIncident.serviceName || !this.newIncident.title || !this.newIncident.description) {
      return;
    }

    this.apiMonitoringService.createIncident(this.newIncident).subscribe({
      next: () => {
        this.newIncident = {
          serviceName: '',
          title: '',
          severity: 'Medium',
          description: ''
        };

        this.loadDashboardData();
      },
      error: (error) => {
        console.error('Error creating incident:', error);
      }
    });
  }

  resolveIncident(id?: number): void {
    if (!id) {
      return;
    }

    this.apiMonitoringService.resolveIncident(id).subscribe({
      next: () => {
        this.loadDashboardData();
      },
      error: (error) => {
        console.error('Error resolving incident:', error);
      }
    });
  }

  getTotalServices(): number {
    return this.services.length;
  }

  getHealthyServices(): number {
    return this.services.filter(service => service.status === 'Healthy').length;
  }

  getDegradedServices(): number {
    return this.services.filter(service => service.status === 'Degraded').length;
  }

  getDownServices(): number {
    return this.services.filter(service => service.status === 'Down').length;
  }

  getOpenIncidents(): number {
    return this.incidents.filter(incident => incident.status === 'Open').length;
  }

}