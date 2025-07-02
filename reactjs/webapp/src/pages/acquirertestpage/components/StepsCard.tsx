// src/components/CaseList/StepsCard.tsx

import { Box, Typography } from "@mui/material";

type StepsCardProps = {
  step1Status: "success" | "error" | "pending";
};

export function StepsCard({ step1Status }: StepsCardProps) {
  return (
    <Box
      sx={{
        display: "flex",
        padding: 1,
        gap: 2,
        justifyContent: "center",
        mt: 1,
      }}
    >
      {/* Шаг 1 */}
      <Box
        sx={{
          px: 3,
          py: 1.5,
          borderRadius: 2,
          backgroundColor:
            step1Status === "success"
              ? "#d1fae5"
              : step1Status === "error"
              ? "#fee2e2"
              : "#e5e7eb",
          border: "1px solid",
          borderColor:
            step1Status === "success"
              ? "#10b981"
              : step1Status === "error"
              ? "#ef4444"
              : "#d1d5db",
        }}
      >
        <Typography variant="body1" fontWeight={600}>
          Шаг 1
        </Typography>
        <Typography variant="body2">Отправка данных на сервер</Typography>
      </Box>

      {/* Шаг 2 */}
      <Box
        sx={{
          px: 3,
          py: 1.5,
          borderRadius: 2,
          backgroundColor: "#f9fafb",
          border: "1px dashed #d1d5db",
          color: "#9ca3af",
        }}
      >
        <Typography variant="body1" fontWeight={600}>
          Шаг 2
        </Typography>
        <Typography variant="body2">
          Получение обратной связи (ещё не реализован)
        </Typography>
      </Box>
    </Box>
  );
}
