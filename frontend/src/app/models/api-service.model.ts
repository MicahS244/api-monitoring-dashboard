export interface ApiService { 
    id: number;
    name: string;
    url: string;
    status: string;
    averageResponseTime: number; // in milliseconds
    errorRate: number;
    lastChecked: string; // ISO date string
}