import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(
    private router: Router,
    private auth: AuthService,
  ) {}

  @Output() loginSuccess = new EventEmitter<void>();
  login(): void {
    this.auth.login(this.username, this.password).subscribe({
      next: () => {
        sessionStorage.setItem('isLoggedIn', 'true');
        this.loginSuccess.emit();
        this.router.navigate(['/app']);
      },
      error: (error) => {
        this.errorMessage = 'Invalid username or password';
      },
    });
  }
}
