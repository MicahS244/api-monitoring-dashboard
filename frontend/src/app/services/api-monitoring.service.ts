import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Incident } from '../models/incident.model';
import { ApiService } from '../models/api-service.model';

@Injectable({
  providedIn: 'root'
})
export class ApiMonitoringService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getServices(): Observable<ApiService[]> {
    return this.http.get<ApiService[]>(`${this.apiUrl}/services`);
  }
  
  getIncidents(): Observable<Incident[]> {
    return this.http.get<Incident[]>(`${this.apiUrl}/incidents`);
  }
  
  createIncident(incident: Incident): Observable<Incident> {
    return this.http.post<Incident>(`${this.apiUrl}/incidents`, incident);
  }

  resolveIncident(id: number): Observable<Incident> {
  return this.http.put<Incident>(`${this.apiUrl}/incidents/${id}/resolve`, {});
}
}
