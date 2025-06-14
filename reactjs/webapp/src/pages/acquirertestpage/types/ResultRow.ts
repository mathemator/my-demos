export interface ResultRow {
  sentAt: string;
  requestId: string;
  traceId: string;
  deliveryTime: string;
  body: string;
  error: string | null;
}

export interface PageInfo {
  totalPages: number;
  totalElements: number;
  number: number;
  size: number;
  first: boolean;
  last: boolean;
  numberOfElements: number;
  empty: boolean;
}

export interface PagedResponse<T> {
  content: T[];
  totalPages: number;
  totalElements: number;
  number: number;
  size: number;
  first: boolean;
  last: boolean;
  numberOfElements: number;
  empty: boolean;
}