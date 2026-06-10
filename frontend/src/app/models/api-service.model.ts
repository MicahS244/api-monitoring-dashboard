export interface ApiService {
  id: number;
  name: string;
  ownerTeam: string;
  environment: string;
  url: string;
  status: string;
  averageResponseTimeMs: number; // in milliseconds
  errorRate: number;
  lastCheckedAt: string; // ISO date string
}
