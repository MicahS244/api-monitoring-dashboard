export interface Incident {
    id?: number;
    serviceName: string;
    title: string;
    severity: string;
    status?: string;
    description: string;
    createdAt?: string; // ISO date string
}