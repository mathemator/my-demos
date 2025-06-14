// src/components/CaseList/TraceIdCard.tsx

import { Box, Checkbox, FormControlLabel } from "@mui/material";
import { Card } from "src/components/ui/card/Card";
import { CardContent } from "src/components/ui/card/CardContent";
import { Button } from "src/components/ui/button/Button";
import { Input } from "src/components/ui/input/Input";
import { Label } from "src/components/ui/label/Label";

type TraceIdCardProps = {
  traceId: string;
  setTraceId: (value: string) => void;
  showAllTraceIds: boolean;
  setShowAllTraceIds: (value: boolean) => void;
  onGenerate: () => void;
  onUpdate: () => void;
  isRefreshDisabled: boolean;
};

export function TraceIdCard({
  traceId,
  setTraceId,
  showAllTraceIds,
  setShowAllTraceIds,
  onGenerate,
  onUpdate,
  isRefreshDisabled,
}: TraceIdCardProps) {
  return (
    <Card>
      <CardContent>
        <Box sx={{ display: "flex", flexDirection: "column", gap: 2 }}>
          <Box>
            <Label htmlFor="traceId">Trace ID</Label>
            <Input
              id="traceId"
              value={traceId}
              onChange={(e) => setTraceId(e.target.value)}
              placeholder="введите traceId"
              disabled={showAllTraceIds}
            />
          </Box>
          <FormControlLabel
            control={
              <Checkbox
                checked={showAllTraceIds}
                onChange={(e) => setShowAllTraceIds(e.target.checked)}
              />
            }
            label="Показать данные для всех traceId"
          />
          <Box sx={{ display: "flex", flexWrap: "wrap", gap: 2, pt: 2 }}>
            <Button onClick={onGenerate}>Сгенерировать</Button>
            <Button onClick={onUpdate} disabled={isRefreshDisabled}>
              Обновить
            </Button>
          </Box>
        </Box>
      </CardContent>
    </Card>
  );
}
