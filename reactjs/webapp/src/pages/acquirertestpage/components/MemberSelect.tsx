// components/MemberSelect.tsx
import { FormControl, InputLabel, Select, MenuItem, Box, CircularProgress } from "@mui/material";
import { Label } from "src/components/ui/label/Label";
import { useMembers } from "src/pages/acquirertestpage/hooks/useMembers";

interface MemberSelectProps {
  memberId: string;
  setMemberId: (id: string) => void;
}

export const MemberSelect: React.FC<MemberSelectProps> = ({ memberId, setMemberId }) => {
  const { members, loading } = useMembers();

  return (
    <Box>
      <Label htmlFor="memberId">Эквайрер</Label>
      <FormControl fullWidth variant="outlined" size="small" sx={{ mt: 1 }}>
        <InputLabel id="memberId-label">Выберите банк</InputLabel>
        <Select
          labelId="memberId-label"
          id="memberId"
          value={memberId}
          onChange={(e) => setMemberId(e.target.value as string)}
          label="Выберите банк"
        >
          {loading ? (
            <MenuItem value="" disabled>
              <CircularProgress size={20} />
            </MenuItem>
          ) : (
            members.map((member) => (
              <MenuItem key={member.id} value={member.id.toString()}>
                {member.id} - {member.name}
              </MenuItem>
            ))
          )}
        </Select>
      </FormControl>
    </Box>
  );
};
