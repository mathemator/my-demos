export interface ResultRequestPayload {
  memberId: string;
  esiaId: string;
  traceId?: string;
  allTraceIds?: boolean;
  caseId: number;
}
