import {PagedResponse, ResultRow} from "src/pages/acquirertestpage/types/ResultRow";
import { ResultRequestPayload } from "src/pages/acquirertestpage/api/ResultRequestPayload";

export async function updateResult(caseId: string, page: number, size: number, payload: ResultRequestPayload): Promise<PagedResponse<ResultRow>> {
  const response = await fetch(`/api/results/1?page=${page}&size=${size}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(payload),
  });

  if (!response.ok) {
    const text = await response.text();
    throw new Error(`Ошибка при обновлении: ${text}`);
  }

  return await response.json();
}