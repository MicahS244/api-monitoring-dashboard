import {Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginRequest } from '../models/login-request.model';

@Injectable({
    providedIn: 'root'
})

export class AuthService {
    private apiUrl = 'http://localhost:8080/api/auth';

    constructor(private http: HttpClient) {}

    login(username: string, password: string): Observable<string> {
        const request: LoginRequest = { username, password };
        return this.http.post<string>(`${this.apiUrl}/login`, request, { responseType: 'text' as 'json' });
    }

    logout(): void {
        sessionStorage.removeItem('isLoggedIn');
    }

    isLoggedIn(): boolean {
        return sessionStorage.getItem('isLoggedIn') == 'true';
    }
}