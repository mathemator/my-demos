// src/components/CaseList/MemberEsiaSection.tsx

import { Box, Card, CardContent } from "@mui/material";
import { Input } from "src/components/ui/input/Input";
import { Label } from "src/components/ui/label/Label";
import { Button } from "src/components/ui/button/Button";
import { MemberSelect } from "src/pages/acquirertestpage/components/MemberSelect";

type MemberEsiaSectionProps = {
  memberId: string;
  setMemberId: (id: string) => void;
  esiaId: string;
  setEsiaId: (id: string) => void;
  handleSubmit: () => void;
  isSubmitDisabled: boolean;
};

export function MemberEsiaSection({
  memberId,
  setMemberId,
  esiaId,
  setEsiaId,
  handleSubmit,
  isSubmitDisabled,
}: MemberEsiaSectionProps) {
  return (
    <Box sx={{ width: "100%", maxWidth: 800 }}>
      <Card>
        <CardContent>
          <Box
            sx={{
              display: "grid",
              gridTemplateColumns: { xs: "1fr", md: "1fr 1fr" },
              gap: 2,
            }}
          >
            <MemberSelect memberId={memberId} setMemberId={setMemberId} />
            <Box>
              <Label htmlFor="esiaId">Идентификатор ЕСИА</Label>
              <Input
                id="esiaId"
                placeholder="Введите esiaId"
                value={esiaId}
                onChange={(e) => setEsiaId(e.target.value)}
              />
            </Box>
          </Box>

          <Box sx={{ display: "flex", justifyContent: "flex-end", pt: 4 }}>
            <Button onClick={handleSubmit} disabled={isSubmitDisabled}>
              Отправить
            </Button>
          </Box>
        </CardContent>
      </Card>
    </Box>
  );
}
